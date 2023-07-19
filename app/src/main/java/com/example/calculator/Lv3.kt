package com.example.calculator

fun main(){


    println("연산하실 방식을 번호에 맞게 *숫자*를 골라주세요.")
    println("1. 더하기")
    println("2. 빼기")
    println("3. 곱하기")
    println("4. 나누기")
    var operator = readLine()!!.toInt()

    if( operator>4 ){
        println("잘못된 입력을 하셨습니다. 프로그램을 종료합니다.")
        return
    }

    println("계산하실 숫자 중 첫번째 숫자를 적어주세요.")
    var inputNum1 = readLine()!!.toInt()


    println("계산하실 숫자 중 하나를 적어주세요.")
    var inputNum2 = readLine()!!.toInt()

    var calc = CalculatorLv3(inputNum1,inputNum2,operator)
    calc.Calculate()

}

class CalculatorLv3(num1:Int, num2: Int, or: Int) {
    var num1: Int = 0
    var num2: Int = 0
    var or: Int = 0
    var result: Int = 0

    init {
        this.num1 = num1
        this.num2 = num2
        this.or = or
    }

    fun Calculate() {
        if (or == 1) {
            var result = AddOperation(num1, num2)
            result.Calc()
        } else if (or == 2) {
            var result = SubstractOperation(num1, num2)
            result.Calc()
        } else if (or == 3) {
            var result = MultiplyOperation(num1, num2)
            result.Calc()
        } else if (or == 4) {
            var result = DivideOperationOperation(num1, num2)
            result.Calc()

        }

    }

    class AddOperation(num1: Int, num2: Int) {
        private var result = num1 + num2
        private var num1 = num1
        private var num2 = num2

        fun Calc() {
            println("${num1} + ${num2} 의 값은 ${result}입니다.")
        }


    }

    class SubstractOperation(num1: Int, num2: Int) {
        private var result = num1 - num2
        private var num1 = num1
        private var num2 = num2
        fun Calc() {
            println("${num1} - ${num2} 의 값은 ${result}입니다.")
        }


    }

    class MultiplyOperation(num1: Int, num2: Int) {
        private var result = num1 * num2
        private var num1 = num1
        private var num2 = num2
        fun Calc() {
            println("${num1} * ${num2} 의 값은 ${result}입니다.")
        }


    }

    class DivideOperationOperation(num1: Int, num2: Int) {
        private var result = num1 / num2
        private var num1 = num1
        private var num2 = num2
        fun Calc() {
            println("${num1} / ${num2} 의 값은 ${result}입니다.")
        }


    }
}