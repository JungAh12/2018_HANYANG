GAME DEVELOP NOTATION
======================

1. Naming
  - for문 내 사용하는 변수 외에는 x, y, z같은 추상적인 이름은 사용하지 않기.
    ```
    ex)for(int i = 0 ; i < GAMETIME ; i++){
       int time += i;
     }                                 //for문 내에서 사용하는 i 같은 변수 외에는 사용하는 변수이름을 알아보기 쉽게.
    ```
    
    
  - class명과 생성자 함수명은 대문자로 시작
    ```
    ex) class Time{                //class명 대문자로 시작
         public Time(){           //생성자명 대문자로 시작
           ...
         }
       }
    ```    
        
        
  - 일반 function은 소문자로 시작, 띄어쓰기가 들어가는 경우 뒷 단어의 시작을 대문자로 한다
    ```
      ex) main(){
         void addTime(){}        //단어가 두개의 어절 이상에는 뒷 단어의 시작을 대문자
          void score(){}          //단어가 하나일때는 그냥 소문자 가능
        }
     ```   
        
2. 주석
  - 자기이름 : 동작 설명
  
3. 최대한 함수로 만들 수 있는 것은 만들기
  - 클래스 내에서 연산하는 경우가 거의 없도록
  - 변수에 알맞는 접근지정자 사용하기
  - 변하면 안되는 값들은 변수 상수화하기