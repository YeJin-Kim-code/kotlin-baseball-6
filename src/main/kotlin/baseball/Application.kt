package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
fun main() {
    //TODO("프로그램 구현")
    BaseballGame()

}
var number : Int = 0;
var intComArray = IntArray(3)
var intPlayerArray = IntArray(3)
fun BaseballGame() {
    var nowCountNumber : Int = 0
    number = Randoms.pickNumberInRange(100, 999)
    println(number)
    var number1 = number/100
    intComArray[0] = number1
    var number2 = (number % 100) / 10
    intComArray[1] = number2
    var number3 = number % 10
    intComArray[2] = number3
    println("숫자 야구 게임을 시작합니다.")

    while(true)
    {
        print("숫자를 입력해주세요 : ")
        var input = Console.readLine()
        var playerNum = input.toInt()
        println("입력한 숫자는 $input 입니다.")
        var playerNum1 = playerNum/100
        intPlayerArray[0] = playerNum1
        var playerNum2 = (playerNum % 100) / 10
        intPlayerArray[1] = playerNum2
        var playerNum3 = playerNum % 10
        intPlayerArray[2] = playerNum3

        println(ballOrStrikeCheck(intComArray, intPlayerArray))
        if(playerNum == number)
        {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }

    }

}

fun ballOrStrikeCheck(intComArray:IntArray, intPlayerArray:IntArray):String
{
    //스트라이크 개수
    var strikeCount:Int = 0
    for(i in 0..intComArray.size - 1)
    {
        var intCom = intComArray[i]
        var intPlayer = intPlayerArray[i]
        if(intCom == intPlayer)
        {
            strikeCount = strikeCount + 1
        }
    }
    var ballCount:Int = 0
    for(i in 0..intComArray.size - 1)
    {
        var intCom = intComArray[i]
        var intPlayer = intPlayerArray[i]
        if(intCom != intPlayer && intComArray.contains(intPlayer))
        {
            ballCount = ballCount + 1
        }
    }
    return " ${ballCount}볼 ${strikeCount}스트라이크"
}
