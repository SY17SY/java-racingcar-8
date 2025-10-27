# 우아한테크코스 8기 프리코스 - 2주차: Racingcar

## 기능 목록

- [x] 경주할 자동차의 이름과 시도할 횟수를 입력 받기
- [x] 실행 결과 출력하기
- [x] 최종 우승자 (단독) 안내 출력하기
- [x] 최종 우승자 (공동) 안내 출력하기

---

## 예외 목록 (IAE 발생)

- [x] 경주할 자동차의 이름으로 쉼표(,)가 없는 문자열을 입력 받을 때: "자동차 이름이 쉼표(,)로 구분되지 않았습니다."
- [x] 경주할 자동차의 이름으로 쉼표(,)로 시작하는 문자열을 입력 받을 때: "자동차 이름은 빈 문자열이 될 수 없습니다."
- [x] 경주할 자동차의 이름으로 쉼표(,)로 끝나는 문자열을 입력 받을 때: "자동차 이름은 빈 문자열이 될 수 없습니다."
- [x] 경주할 자동차의 이름으로 연속하는 쉼표(,)가 포함된 문자열을 입력 받을 때: "자동차 이름은 빈 문자열이 될 수 없습니다."

---

- [x] 쉼표(,)를 기준으로 분리한 문자열 중 하나가 빈 문자열일 때: "경주할 자동차의 이름은 빈 문자열이 될 수 없습니다."
- [x] 쉼표(,)를 기준으로 분리한 문자열 중 2개가 동일한 문자열일 때: "자동차 이름은 모두 달라야 합니다."
- [x] 쉼표(,)를 기준으로 분리한 문자열 중에 하나가 5자를 초과할 때: "자동차 이름은 5자 이하만 가능합니다."
- [x] 쉼표(,)를 기준으로 분리한 문자열 중 하나에 영어 대/소문자, 숫자가 아닌 문자가 포함될 때: "자동차 이름은 영어 대/소문자나 숫자로만 이루어질 수 있습니다."

---

- [x] 시도할 횟수로 빈 문자열을 입력 받을 때: "시도할 횟수를 작성해 주십시오."
- [x] 시도할 횟수로 숫자가 아닌 문자를 입력 받을 때: "시도할 횟수에 문자가 포함될 수 없습니다."
- [x] 시도할 횟수로 음수를 입력 받을 때: "시도할 횟수는 음수가 될 수 없습니다."
- [x] 시도할 횟수로 int 범위를 넘어가는 수를 입력 받을 때: "시도할 횟수는 int 범위를 초과할 수 없습니다."

---

## 생각의 흐름

이번에는 객체지향, 구조 설계, 책임 분리에 신경을 써야겠다는 생각을 했습니다.

우선 구조 설계를 위해 model, view, controller, domain 패키지와 util 패키지를 생성했습니다.

기능 목록과 예외 목록을 작성하여, 우선 통합 테스트를 작성했습니다.

먼저 정상 입력에 대한 로직을 작성했습니다. 

---

#### racingcar.view 패키지

validator 없이 정상 입력을 받고 반환하는 ConsoleInput 클래스,

로직 없이 Prompt를 출력하는 ConsoleOutput 클래스를 매직 리터럴 등을 이용해서 구현했습니다.

---

#### racingcar.model 패키지

각각의 자동차 객체를 담을 Car 클래스와, List<Car>을 담은 Cars 클래스, 그리고 getter의 사용을 지양하기 위한 CarState 레코드를 생성했습니다.

getName, getPosition은 default 접근 제어자를 이용하여, 동일한 패키지 내의 CarState를 이용하여 필요한 속성을 가져왔습니다.

(1-1) 처음에는 strategy 없이 Car 클래스가 직접 Random 로직을 진행하도록 구현했습니다.

Cars 클래스에서 매 라운드마다의 snapshot을 반환하여 실행 결과를 출력할 때 이용할 수 있도록 했습니다.

(2-1) 처음에는 Cars 클래스의 findWinnerNames 메서드에서 Car 클래스의 getter을 이용하도록 구현했습니다.

---

#### racingcar.controller 패키지

controller의 runController 메서드에서 전체적인 흐름이 나타나도록 했습니다.

inputName와 count을 입력 받고, 실행 결과와 우승자를 출력합니다.

---

#### racingcar.domain 패키지

(3-1) 우선 처음에는 Racingcar 클래스에서 parseNames, createCars 로직을 작성했습니다. 

Cars의 raceOneRound 메서드를 이용해서 race를 진행하고 Consumer onEachRound로 printExecutionResult 콜백을 매개변수로 전달했습니다.

---

#### racingcar.domain.parser 패키지, Cars fromNames 생성자

(3-2) NameParser와 Cars fromNames를 Racingcar에서 분리했습니다. 

---

### 정상 입력 케이스 완료, 예외 입력 케이스 시작

---

#### racingcar.domain.validator 패키지

예외 목록을 작성할 때, 검증하는 시점을 기준으로 예외 목록을 나누어 작성하였습니다.

1. String InputName을 검증하는 클래스
2. List<String> names을 검증하는 클래스
3. String InputCount을 검증하는 클래스

(4-1) 처음에는 빈 문자열을 검증하는 method를 각각 작성했고, Pattern과 Matcher을 이용하지 않았습니다.  

---

#### racingcar.domain.strategy 패키지 추가

(1-2) MoveStrategy 인터페이스와 RandomMoveStrategy 클래스를 추가해, Car 클래스에 있던 해당 로직을 리팩토링했습니다. 

---

#### racingcar.domain.validator 패키지

(4-2) 공통 로직인 trimOrNull을 Validator 클래스으로 리팩토링했습니다. 

(4-3) Pattern과 Matcher을 이용하도록 리팩토링했습니다. 

---

#### racingcar.model 패키지

(2-2) Cars 클래스의 findWinnerNames 메서드가 Car 클래스의 getName(), getPosition() 대신 CarState를 이용하도록 했습니다.

---

#### racingcar.domain 패키지

race와 findWinners 메서드를 통합했습니다.

---

### 최종적으로

Application: 의존성을 주입하여 RacingcarController을 실행한다.

Controller: String inputName을 입력받은 후 (InputNameValidator로 검증), NameParser을 호출한다.

NameParser: List<String> names가 반환된다. (ListNameValidator로 검증)

Controller: Cars cars 인스턴스를 생성한다.

Controller: String inputCount를 입력받은 후 (InputCountValidator로 검증), int count가 반환된다.

Controller: race를 진행하기 위해 racingcar.race 메서드를 호출한다.

Racingcar.race: count만큼의 라운드를 진행하고 매개변수로 받은 printExecutionResult를 이용해 실행 결과를 출력한다.

Racingcar.race: Cars 클래스의 findWinnerNames 메서드를 통해 List<String> winners를 반환한다.

Controller: 우승자를 출력하고 콘솔을 닫는다.
