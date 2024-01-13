package me.dgpr.node;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Optional;

public class MacAddressNodeIdentifier implements NodeIdentifier {
    private static final int MAC_ADDRESS_LEN = 6;
    private final byte[] macAddress;

    private MacAddressNodeIdentifier(byte[] macAddress) {
        this.macAddress = macAddress;
    }

    public static MacAddressNodeIdentifier newInstance() {
        byte[] macAddr =
                findViableMacAddress().orElseThrow(() -> new IllegalStateException("No viable MAC address found"));
        return newInstance(macAddr);
    }

    public static MacAddressNodeIdentifier newInstance(String interfaceName) {
        byte[] macAddr = getMacAddressFromInterface(interfaceName).orElseThrow(() -> new IllegalStateException(
                "Cannot get MAC address from interface " + interfaceName));
        return newInstance(macAddr);
    }

    private static MacAddressNodeIdentifier newInstance(byte[] macAddress) {
        Objects.requireNonNull(macAddress, "MAC address should not be null");
        if (macAddress.length != MAC_ADDRESS_LEN) {
            throw new IllegalArgumentException("Invalid MAC address");
        }
        return new MacAddressNodeIdentifier(macAddress);
    }

    private static Optional<byte[]> findViableMacAddress() {
        try {
            Enumeration<NetworkInterface> nics = NetworkInterface.getNetworkInterfaces();
            while (nics.hasMoreElements()) {
                NetworkInterface currentNic = nics.nextElement();
                if (!currentNic.isLoopback() && currentNic.isUp() && (currentNic.getHardwareAddress() != null)) {
                    return Optional.of(currentNic.getHardwareAddress());
                }
            }
        } catch (SocketException e) {
            throw new IllegalStateException(e);
        }
        return Optional.empty();
    }

    private static Optional<byte[]> getMacAddressFromInterface(String networkInterface) {
        try {
            NetworkInterface nic = NetworkInterface.getByName(networkInterface);
            return (nic != null) ? Optional.of(nic.getHardwareAddress()) : Optional.empty();
        } catch (SocketException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public long get() {
        long macAsLong = 0;
        for (int i = 0; i < MAC_ADDRESS_LEN; i++) {
            long temp = (macAddress[i] & 0xFFL) << ((5 - i) * 8);
            macAsLong |= temp;
        }
        return macAsLong;
    }
}
