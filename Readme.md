# Reflection 프로젝트
[Reflection이란?](https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/index.html)
이 공식 문서를 참고하여 학습하였습니다.

### 개요
이 프로젝트는 **Reflection API**를 사용하여 클래스, 메서드, 필드, 생성자 등의 정보를 다루고, 런타임에서 객체를 조작하는 다양한 방법을 학습합니다.

---

## 프로젝트 구조
```
Reflection/
├── src/
│   ├── com/
│   │   ├── sj/
│   │   │   ├── Arrays/
│   │   │   │   ├── reflectionapi1/ArrayCreator.java      # 배열 생성 예제
│   │   │   │   ├── reflectionapi3/CreateMatrix.java     # 다차원 배열 생성
│   │   │   ├── classes/
│   │   │   │   ├── reflectionapi/Parent.java            # 상위 클래스
│   │   │   │   ├── reflectionapi/Child.java             # 하위 클래스
│   │   │   ├── constructors/
│   │   │   │   ├── reflectionapi1/ConstructorSift.java  # 생성자 탐색
│   │   │   ├── methods/
│   │   │   │   ├── Invoking/InvokeMain.java             # 메서드 호출 예제
└── pom.xml                                              # Maven 설정 파일
```

---

## 주요 기능

### 1. **Reflection을 사용한 클래스 정보 접근**
- 클래스, 필드, 메서드, 생성자 정보 탐색.
- `Class` 객체를 사용한 런타임 조작.

### 2. **다양한 Reflection 실습**
- 배열 생성 및 조작 (`ArrayCreator`).
- 상속 관계의 클래스 조작 (`Parent`, `Child`).
- 생성자 및 필드의 정보 탐색과 접근 (`ConstructorSift`).

---

## 실행 방법

1. **필수 요건**
   - Java 17 이상
   - Maven 설치

2. **실행**
   - 터미널에서 프로젝트 디렉토리로 이동:
     ```bash
     cd Reflection
     ```
   - Maven 빌드 및 실행:
     ```bash
     mvn exec:java
     ```
   - 각 클래스의 동작을 확인.