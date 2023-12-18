# 바이트코드

## 바이트코드 조작

### 스프링이 컴포넌트 스캔을 하는 방법

- 바이트코드 조작 라이브러리 `ASM`을 사용함
- 컴포넌트 스캔으로 빈으로 등록할 후보 클래스 정보를 찾는데 사용
- `ClassPathScanningCandidateComponentProvider` -> `SimpleMetadataReader` -> `ClassReader`와 `Visitor` 사용해서 클래스에 있는 메타
  정보를 읽어온다

> 참고:
> <br>
> https://www.youtube.com/watch?v=39kdr1mNZ_s
> <br>
> ASM, Javassist, ByteBuddy, CGlib