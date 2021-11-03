// 이메일 형식체크
function isEmail(element) {
    var re_mail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/; // 이메일 검사식

    if (re_mail.test($(element).val()) != true) {
        $(element).focus();
        return false;
    }
    return true;
}