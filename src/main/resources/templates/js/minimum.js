function click1(){

    let check1 = document.getElementById("first").checked;
    let check2 = document.getElementById("second").checked;
    let check3 = document.getElementById("third").checked;
    let check4 = document.getElementById("fourth").checked;
    let check5 = document.getElementById("fifth").checked;
    let check6 = document.getElementById("sixth").checked;
    let allCheck = [check1, check2, check3, check4, check5, check6];
    let totalChecked = 0;
    for (let i = 0; i < 6; i++) {
        if(allCheck[i]){

            totalChecked++;
        }
    }
    if (totalChecked < 4){
        alert("Виберіть мінімум 4 рівні")
        return false;
    }
    return true;


}