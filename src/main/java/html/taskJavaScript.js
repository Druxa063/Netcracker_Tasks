function formOverSetValue() {
var x = document.getElementById("idNameWorker").value;
if (x == "например, Иванов") {
document.getElementById("idNameWorker").value = "";
}
return false;
}

function formOutSetValue() {
var x = document.getElementById("idNameWorker").value;
if (x == "") {
document.getElementById("idNameWorker").value = "например, Иванов";
}
return false;
}

function checkNumber() {
    var x = document.forms[0].numberWorker.value;
    var patt1 = /\w/g;
    if (patt1.test(x)) {
        alert("необходимо ввести число");
        return false;
    }
}

function deleteRow(r) {
    var check = confirm("Do you want to remove?");
    if (check) {
        var i = r.parentNode.parentNode.rowIndex;
        document.getElementById("table").deleteRow(i);
    }
}

function redirect() {
    var text = encode_utf8("taskJavaScript.html?nameWorker=" + document.getElementById("idNameWorker").value);
    document.location = text;
}

function onLoad() {
    var paramValue = window.location.href.split("?")[1].split("=")[1];
    document.forms[0].nameWorker.value = decode_utf8(paramValue);
}

function encode_utf8(s) {
  return encodeURI(s);
}

function decode_utf8(s) {
  return decodeURI(s);
}