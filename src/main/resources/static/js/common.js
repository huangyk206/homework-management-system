var userName="";
function  getUrlParam(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
    if(r!=null)
        return  decodeURI(r[2]);
    return null;
}

function timestampToTime(timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear();
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1);
    D = date.getDate()<10?('0'+date.getDate()):(date.getDate());
    h = date.getHours()<10?('0'+date.getHours()):(date.getHours());
    m = date.getMinutes()<10?('0'+date.getMinutes()):(date.getMinutes());
    s = date.getSeconds()<10?('0'+date.getSeconds()):(date.getSeconds());
    return Y+"-"+M+"-"+D+" "+h+":"+m+":"+s;
}

function decode(str) {
    return unescape(str.replace(/&#x/g,'%u').replace(/;/g,''))
}