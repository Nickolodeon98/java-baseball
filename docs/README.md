# 기능 목록

## 1. void pickRndNumbers()

``1 에서 9 사이의 세 개의 무작위 숫자를 선택한다. 출력하지 않고 리스트형 변수에 저장만 한다.``

## 2. int isStrikeOrBallOrNothing(int elemToBeJudged, int pos)

``주어진 숫자 elemToBeJudged 와 플레이어가 부른 세 개 숫자 안에서 이 숫자의 위치 pos 를 토대로 세 개의 무작위 숫자와 비교해서
스트라이크면 1, 볼이면 2, 낫싱이면 0을 리턴한다.``

## 3. HashMap<String, Integer> distinguish(List<Integer> playerSide)

``플레이어가 입력한 세 개의 숫자가 리스트에 담겨 이 메서드의 매개 변수로 사용된다. 볼 카운트 또는 낫싱에 대한 정보를 해시 맵에 저장한다.``

## 4. String printToConsole(Map<String, Integer> ballCount)

``주어진 볼 카운트 정보를 담은 해시 맵을 토대로 문자열 형태의 힌트를 생성해 리턴한다.``