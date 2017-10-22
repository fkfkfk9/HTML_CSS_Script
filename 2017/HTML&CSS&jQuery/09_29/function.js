/*<--------------------- 출력 함수------------------->*/
function pnt(a) {
    //출력함수 값이 null이나 undefined일 경우 출력시키지 않고 리턴
    if (a == undefined || a == null) return;
    document.write(a + "<br>");
}
/*<--------------------- 출력 함수------------------->*/
function alt(a) {
    //출력함수 값이 null이나 undefined일 경우 출력시키지 않고 리턴
    if (a == undefined || a == null) return;
    alert("계산결과 : " + a);
}
/*<------------------합을 구하는 함수---------------->*/
function sum(x, y) {
    //들어온 값이 둘 중 하나라도 문자가 들어온다면 리턴
    if (typeof (x) == "string" || typeof (y) == "string") {
        pnt("숫자가 아닙니다.");   
        return;
    }
    //합을 리턴
    return x + y;
}
/*<------------------차를 구하는 함수---------------->*/
function sub(x, y) {
    if (typeof (x) == "string" || typeof (y) == "string") {
        pnt("숫자가 아닙니다.");
        return;
    }
    //차를 리턴
    return x - y;
}
/*<------------------곱을 구하는 함수---------------->*/
function mul(x, y) {
    if (typeof (x) == "string" || typeof (y) == "string") {
        pnt("숫자가 아닙니다.");
        return;
    }
    //곱을 리턴
    return x * y;
}
/*<------------------몫을 구하는 함수---------------->*/
function divide(x, y) {
    if (typeof (x) == "string" || typeof (y) == "string") {
        pnt("숫자가 아닙니다.");
        return;
    }
    //몫을 리턴
    return x / y;
}
/*<---------------------계산기 함수-------------------->*/
function calculator(x, y, z) {    
    //리턴값을 선언
    var num;
    //들어온 문자에 따라 리턴값을 계산한다.
    switch (y) {
        case "+":
            num = x + z;
            break;
        case "-":
            num = x - z;
            break;
        case "*":
            num = x * z;
            break;
        case "/":
            num = x / z;
            break;
        default://문자가 정해진 규격을 벗어날 경우
            alert("연산자가 틀렸습니다.");
            return;
    }
    //문자가 Number함수로 변해올 경우 계산이 안되는대 그럴경우를 판단
    if (isNaN(result)) {
        alert("숫자가 아닙니다.");
        return;
    }
    return num;
}
