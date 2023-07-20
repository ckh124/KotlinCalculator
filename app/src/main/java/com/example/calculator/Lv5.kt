package com.example.calculator

fun main(){
//인자가 3개일 시 계산법 알아보기

    println("계산하실 숫자 중 첫 번째 숫자를 적어주세요.")
    var inputNum1 = readLine()!!.toDouble()

    println("연산하실 방식을 번호에 맞게 *숫자*를 골라주세요.")
    println("1. 더하기")
    println("2. 빼기")
    println("3. 곱하기")
    println("4. 나누기")
    var operator1 = readLine()!!.toInt()


    if( operator1>4 ){
        println("잘못된 입력을 하셨습니다. 프로그램을 종료합니다.")
        return
    }



    println("계산하실 숫자 중 두 번째 숫자를 적어주세요.")
    var inputNum2 = readLine()!!.toDouble()

    println("연산하실 방식을 번호에 맞게 *숫자*를 골라주세요.")
    println("1. 더하기")
    println("2. 빼기")
    println("3. 곱하기")
    println("4. 나누기")
    var operator2 = readLine()!!.toInt()


    if( operator2>4 ){
        println("잘못된 입력을 하셨습니다. 프로그램을 종료합니다.")
        return
    }

    println("계산하실 숫자 중 세 번째 숫자를 적어주세요.")
    var inputNum3 = readLine()!!.toDouble()

    var calc = CalculatorLv5(inputNum1,inputNum2,inputNum3,operator1,operator2)
    calc.Calculate()

}

class CalculatorLv5(num1:Double, num2: Double,num3:Double, or1: Int, or2:Int) {
    var num1: Double = 0.0
    var num2: Double = 0.0
    var num3: Double = 0.0
    var or1: Int = 0
    var or2: Int = 0
    var middleResult: Double = 0.0
    var result: Double = 0.0

    init {
        this.num1 = num1
        this.num2 = num2
        this.num3 = num3

        this.or1 = or1
        this.or2 = or2

    }

    fun Calculate() {

        if (or1 == 1) {
            if (or2 == 1) {//두 연산이 덧셈일 때,

                var a = AddOperation()
                var b = AddOperation()
                middleResult = a.Calc(num2, num3)
                result = b.Calc(num1, middleResult)

                println("${num1}+${num2}+${num3}의 값은 ${result}입니다.")

            } else if (or2 == 2) { //덧셈, 뺼셈일 때,

                var a = SubstractOperation()
                var b = AddOperation()
                middleResult = a.Calc(num2, num3)
                result = b.Calc(num1, middleResult)

                println("${num1}+${num2}-${num3}의 값은 ${result}입니다.")

            } else if (or2 == 3) { //앞 연산이 덧셈이고 뒷 연산이 곱셈이라 뒷 연산이 우선일 때,

                var a = MultiplyOperation()
                var b = AddOperation()
                middleResult = a.Calc(num2, num3)
                result = b.Calc(num1, middleResult)

                println("${num1}+${num2}*${num3}의 값은 ${result}입니다.")

            } else if (or2 == 4) {//앞 연산이 덧셈이고 뒷 연산이 나눗셈이라 뒷 연산이 우선일 때,

                var a = DivideOperation()
                var b = AddOperation()
                middleResult = a.Calc(num2, num3)
                result = b.Calc(num1, middleResult)

                println("${num1}+${num2}/${num3}의 값은 ${result}입니다.")

            }
        } else if (or1 == 2) {
            if (or2 == 1) {//앞 연산이 뺄셈, 뒷 연산이 덧셈일때

                var a = SubstractOperation()
                var b = AddOperation()
                middleResult = a.Calc(num2, num3)
                result = b.Calc(num1, middleResult)

                println("${num1}-${num2}+${num3}의 값은 ${result}입니다.")

            } else if (or2 == 2) { //두 연산 다 뺄셈일 때

                var a = SubstractOperation()
                var b = SubstractOperation()
                middleResult = a.Calc(num1, num2)
                result = b.Calc(middleResult,num3)

                println("${num1}-${num2}-${num3}의 값은 ${result}입니다.")

            } else if (or2 == 3) { //앞 연산이 뺄셈 뒷 연산이 곱셈이라 뒷 연산이 우선일 때,

                var a = MultiplyOperation()
                var b = SubstractOperation()
                middleResult = a.Calc(num2, num3)
                result = b.Calc(num1, middleResult)

                println("${num1}-${num2}*${num3}의 값은 ${result}입니다.")

            } else if (or2 == 4) {//앞 연산이 덧셈이고 뒷 연산이 나눗셈이라 뒷 연산이 우선일 때,

                var a = DivideOperation()
                var b = SubstractOperation()
                middleResult = a.Calc(num2, num3)
                result = b.Calc(num1, middleResult)

                println("${num1}-${num2}/${num3}의 값은 ${result}입니다.")

            }

        } else if (or1 == 3) {
            if (or2 == 1) {//앞 연산이 곱셈, 뒷 연산이 덧셈일 때

                var a = MultiplyOperation()
                var b = AddOperation()
                middleResult = a.Calc(num1, num2)
                result = b.Calc(middleResult, num3)

                println("${num1}*${num2}+${num3}의 값은 ${result}입니다.")

            } else if (or2 == 2) { //앞 연산이 곱셈, 뒷 연산이 뺄셈일 때

                var a = MultiplyOperation()
                var b = SubstractOperation()
                middleResult = a.Calc(num1, num2)
                result = b.Calc(middleResult, num3)

                println("${num1}*${num2}-${num3}의 값은 ${result}입니다.")

            } else if (or2 == 3) { //앞 연산이 곱셈, 뒷 연산이 곱셈일 때,

                var a = MultiplyOperation()
                var b = MultiplyOperation()
                middleResult = a.Calc(num1, num2)
                result = b.Calc(num3, middleResult)

                println("${num1}*${num2}*${num3}의 값은 ${result}입니다.")

            } else if (or2 == 4) {//앞 연산이 곱셈이고 뒷 연산이 나눗셈이라 뒷 연산이 우선일 때,

                var a = MultiplyOperation()
                var b = DivideOperation()
                middleResult = a.Calc(num1, num2)
                result = b.Calc(num3, middleResult)

                println("${num1}*${num2}/${num3}의 값은 ${result}입니다.")

            }

        } else if (or2 == 4) {

            if (or2 == 1) {//앞 연산이 나눗셈, 뒷 연산이 덧셈일 때

                var a = DivideOperation()
                var b = AddOperation()
                middleResult = a.Calc(num1, num2)
                result = b.Calc(middleResult, num3)

                println("${num1}/${num2}+${num3}의 값은 ${result}입니다.")

            } else if (or2 == 2) { //앞 연산이 나눗셈, 뒷 연산이 뺄셈일 때

                var a = DivideOperation()
                var b = SubstractOperation()
                middleResult = a.Calc(num1, num2)
                result = b.Calc(middleResult, num3)

                println("${num1}/${num2}-${num3}의 값은 ${result}입니다.")

            } else if (or2 == 3) { //앞 연산이 나눗셈, 뒷 연산이 곱셈일 때,

                var a = DivideOperation()
                var b = MultiplyOperation()
                middleResult = a.Calc(num1, num2)
                result = b.Calc(num3, middleResult)

                println("${num1}/${num2}*${num3}의 값은 ${result}입니다.")

            } else if (or2 == 4) {// 둘 다 나눗셈일 때,

                var a = DivideOperation()
                var b = DivideOperation()
                middleResult = a.Calc(num1, num2)
                result = b.Calc(num3, middleResult)

                println("${num1}/${num2}/${num3}의 값은 ${result}입니다.")

            }

        }
    }

}

    class AddOperation():AbstractOperation2(){                         //덧셈


        override fun Calc(num1: Double, num2: Double):Double = (num1 + num2).toDouble()





    }

    class SubstractOperation :AbstractOperation2(){                   //뺼셈

        override fun Calc(num1: Double, num2: Double):Double = (num1 - num2).toDouble()

    }

    class MultiplyOperation :AbstractOperation2(){                      //곱셈


        override fun Calc(num1: Double, num2:Double):Double = (num1 * num2).toDouble()

    }

    class DivideOperation :AbstractOperation2(){               //나눗셈

        override fun Calc(num1: Double, num2: Double):Double = (num1 / num2).toDouble()


    }


    abstract class AbstractOperation2{  //사용이유 - 형식만 선언해둔다(상속과 오버라이딩시 클래스나 함수에 사용하는 open 키워드사용필요 X)

        abstract fun Calc(num1: Double, num2: Double) : Double

    }