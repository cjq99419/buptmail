// 当框框加载完成之后调用设置省份
window.onload = setProvince;

// 获取省市县/区的select选择框对象
let province = document.getElementById("select_province");
// var city = document.getElementsByClassName("select")[1];
// var county = document.getElementsByClassName("select")[2];

// 设置省份
function setProvince() {
    // 遍历省份数组, provinceArr在city.js中
    // for (var i = 0; i < provinceArr.length; i++){
    //     // 创建省份option选项
    //     var opt = document.createElement("option");
    //     opt.value = provinceArr[i];         // 设置value-提交给服务器用
    //     opt.innerHTML = provinceArr[i];     // 设置option文本显示内容
    //     province.appendChild(opt);          // 追加城市到下拉框
    //
    //     // 当省份发生变化更改城市
    //     province.onchange = function(){
    //         setCity(this.selectedIndex);
    //     };
    // }
    let opt = document.createElement("option");
    opt.value = provinceArr[0];
    opt.innerHTML = provinceArr[0];
    // if(opt != null) {
    //     alert(opt.value);
    // }else{
    //     alert("null");
    // }
    province.appendChild(opt);
    if(province != null) {
        alert("aaaa");
    }else{
        alert("null");
    }


    // 省份加载完成，默认显示第一个省份的城市
   // setCity(0);
}

// 设置城市
function setCity(provincePos) {
    // 获取省份对象的城市，cityArr在city.js中
    var citys = cityArr[provincePos];
    city.length = 0;                  // 清空长度，重新从0开始赋值下拉框

    for (var i = 0; i < citys.length; i++){
        // 创建城市option选项
        var opt = document.createElement("option");
        opt.value = citys[i];         // 设置value-提交给服务器用
        opt.innerHTML = citys[i];     // 设置option文本显示内容

        city.appendChild(opt);
        city.onchange = function() {
            setCounty(provincePos, this.selectedIndex);
        }
    }

    // 默认显示城市的第一个县/区
    setCounty(provincePos, 0);
}

// 设置县/区, 县/区是三位数组，需要传入哪个省份和城市
function setCounty(provincePos, cityPos) {
    // 获取县/区，countyArr在city.js中国
    var countys = countyArr[provincePos][cityPos];
    county.length = 0;

    for (var i = 0; i < countys.length; i++){
        // 创建县/区option选项
        var opt = document.createElement("option");
        opt.value = countys[i];         // 设置value-提交给服务器用
        opt.innerHTML = countys[i];     // 设置option文本显示内容
        county.appendChild(opt);        // 追加到县/区选择框中
    }
}