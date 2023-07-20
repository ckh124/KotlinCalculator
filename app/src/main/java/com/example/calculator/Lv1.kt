package com.example.calculator

import android.renderscript.ScriptGroup.Input

fun main(){


    println("연산하실 방식을 골라주세요.")
    var Operator = readLine()!!

    println("계산하실 숫자 중 첫번째 숫자를 적어주세요.")
    var InputNum1 = readLine()!!.toInt()

    println("계산하실 숫자 중 두 번째 숫자를 적어주세요.")
    var InputNum2 = readLine()!!.toInt()

    var calc = Calculator(InputNum1,InputNum2,Operator)
    calc.Calculate()

}
class Calculator(num1:Int, num2: Int, or: String) {
    var num1:Int =0
    var num2:Int =0
    var or:String = ""
    var result:Int = 0

    init{
        this.num1 = num1
        this.num2 = num2
        this.or = or
    }

    fun Calculate(){
        if(or == "+" || or =="더하기" || or =="덧셈"){
            result = num1 + num2
            println("${num1} + ${num2} 의 값은 ${result}입니다.")
        }
        else if(or == "-"|| or =="빼기" || or =="뺄셈"){
            result = num1 - num2
            println("${num1} - ${num2} 의 값은 ${result}입니다.")
        }
        else if(or == "*"|| or =="곱하기" || or =="곱셈"){
            result = num1 * num2
            println("${num1} * ${num2} 의 값은 ${result}입니다.")
        }
        else if(or == "/"|| or =="나누기" || or =="나눗셈"){
            result = num1 / num2
            println("${num1} / ${num2} 의 값은 ${result}입니다.")
        }

    }



}