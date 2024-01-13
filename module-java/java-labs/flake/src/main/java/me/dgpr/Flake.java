package me.dgpr;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.time.Clock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import me.dgpr.node.MacAddressNodeIdentifier;
import me.dgpr.node.NodeIdentifier;

public class Flake {

    private static final int MAX_SEQ = 0xFFFF;
    private static final int ID_SIZE_BYTES = 16;
    private static final int NODE_ID_BYTES = 6;
    private static final String HEX_VALUES = "0123456789abcdef";
    private final Lock lock = new ReentrantLock(true);
    private final byte[] nodeId;
    private final Clock clock;
    private volatile long currentTime;
    private volatile long lastTime;
    private volatile int sequence;

    public static Flake newInstance() {
        return newInstance(MacAddressNodeIdentifier.newInstance());
    }

    public static Flake newInstance(NodeIdentifier nodeIdentifier) {
        return newInstance(nodeIdentifier, Clock.systemUTC());
    }

    public static Flake newInstance(NodeIdentifier nodeIdentifier, Clock clock) {
        long tempNodeId = nodeIdentifier.get();
        byte[] nodeId = new byte[NODE_ID_BYTES];
        for (int i = 0; i < NODE_ID_BYTES; i++) {
            nodeId[i] = (byte) ((tempNodeId >> ((5 - i) * 8)) & 0xFFL);
        }
        return new Flake(nodeId, clock);
    }

    private Flake(byte[] nodeId, Clock clock) {
        this.nodeId = nodeId;
        this.clock = clock;
        this.lastTime = clock.millis();
        this.sequence = -1;
    }

    public byte[] generateId() {
        lock.lock();
        try {
            updateState();
            ByteBuffer idBuffer = ByteBuffer.allocate(ID_SIZE_BYTES);
            return idBuffer.putLong(currentTime).put(nodeId).putShort((short) sequence).array();
        } finally {
            lock.unlock();
        }
    }

    private void updateState() {
        currentTime = clock.millis();
        if (currentTime != lastTime) {
            sequence = 0;
            lastTime = currentTime;
        } else if (sequence == MAX_SEQ) {
            throw new IllegalStateException("Sequence overflow");
        } else {
            sequence++;
        }
    }

    public static String asHexString(byte[] id) {
        final StringBuilder sb = new StringBuilder(2 * id.length);
        for (final byte b : id) {
            sb.append(HEX_VALUES.charAt((b & 0xF0) >> 4)).append(HEX_VALUES.charAt((b & 0x0F)));
        }
        return sb.toString();
    }

    public static String asComponentString(byte[] id) {
        ByteBuffer buffer = ByteBuffer.wrap(id);
        byte[] node = new byte[NODE_ID_BYTES];
        buffer.get(node);
        return buffer.getLong() + "-" + new BigInteger(node).longValue() + "-" + buffer.getShort();
    }
}
