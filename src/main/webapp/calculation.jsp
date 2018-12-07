<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculation</title>
</head>
<body>
    <form method="post" name="formCalculation">
        First operand : <input type="text" name="operand_A"><br><br>
        Second operand : <input type="text" name="operand_B">
    </form>
    <div>
        <button id="addition" onclick="calculation('addition')">Addition</button>
        <button id="subtraction" onclick="calculation('subtraction')">Subtraction</button>
        <button id="multiplication" onclick="calculation('multiplication')">Multiplication</button>
        <button id="division" onclick="calculation('division')">Division</button>
    </div>
    <h3 id="sum"></h3>
</body>
<script language="javascript" type="text/javascript">
    function calculation(action) {
        var xmlhttp, json, operand_A, operand_B;
        operand_A = document.forms["formCalculation"]["operand_A"].value;
        operand_B = document.forms["formCalculation"]["operand_B"].value;
        xmlhttp = new XMLHttpRequest();
        if (isNaN(operand_A) || isNaN(operand_B)) {
            alert("Either or both operands are not number");
            return;
        }
        if (action !== "division" && operand_B !== 0) {
            xmlhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("sum").innerText = this.responseText;
                }
            };
            xmlhttp.open("GET", "calculation?action=" + action + "&operand_A=" + operand_A + "&operand_B=" + operand_B, true);
            xmlhttp.send();
        } else {
            alert("Error division by zero");
        }
    }
</script>
</html>
