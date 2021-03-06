<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../resources/globle.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Title</title>
</head>
<body>

    <label for="province">省份：</label>
    <select id="province">
        <option>--请选择--</option>
    </select>

    <label for="city">市/区：</label>
    <select id="city">
        <option>--请选择--</option>
    </select>

    <label for="college">院校：</label>
    <select id="college">
        <option>--请选择--</option>
    </select>

    <div id="text">
        <span id="leftTime">3</span>秒后弹出1
    </div>
    
    <br>
    <a href="${ctxPath}/helloAjax1">Hello Ajax1</a>
    <br>
    <a href="${ctxPath}/helloAjax2">Hello Ajax2</a>
    <br>
    <a href="${ctxPath}/helloAjax3">Hello Ajax3</a>

    <div id="detail">

    </div>

    <script type="text/javascript">
        window.onload = function () {
            var request = new XMLHttpRequest();
            var url;
            var method = "GET";
            var aNodes = document.getElementsByTagName("a");
            for (var i = 0; i < aNodes.length; i++) {
                aNodes[i].onclick = function () {
                    url = this.href;
                    request.open(method, url);
                    request.send(null);
                    request.onreadystatechange = function () {
                        if (request.readyState === 4) {
                            if (request.status === 200 || request.status === 304) {
                                alert(request.responseText);
                                document.getElementById("detail").innerHTML = "detail: "+ request.responseText;
                            }
                        }
                    };
                    return false;
                };
            }
        }
    </script>


    <script type="text/javascript">
        //定义数组，存储省份信息
        var province = ["北京", "上海", "天津", "重庆", "浙江", "江苏", "广东", "福建", "湖南", "湖北", "辽宁",
            "吉林", "黑龙江", "河北", "河南", "山东", "陕西", "甘肃", "新疆", "青海", "山西", "四川",
            "贵州", "安徽", "江西", "云南", "内蒙古", "西藏", "广西", "宁夏", "海南", "香港", "澳门", "台湾"];

        //定义数组,存储城市信息
        var defaultCity = ["--请选择--"];
        var beijing = ["东城区", "西城区", "海淀区", "朝阳区", "丰台区", "石景山区", "通州区", "顺义区", "房山区", "大兴区", "昌平区", "怀柔区", "平谷区", "门头沟区", "延庆县", "密云县"];
        var shanghai = ["浦东新区", "徐汇区", "长宁区", "普陀区", "闸北区", "虹口区", "杨浦区", "黄浦区", "卢湾区", "静安区", "宝山区", "闵行区", "嘉定区", "金山区", "松江区", "青浦区", "南汇区", "奉贤区", "崇明县"];
        var tianjing = ["河东", "南开", "河西", "河北", "和平", "红桥", "东丽", "津南", "西青", "北辰", "塘沽", "汉沽", "大港", "蓟县", "宝坻", "宁河", "静海", "武清"];
        var chongqing = ["渝中区", "大渡口区", "江北区", "沙坪坝区", "九龙坡区", "南岸区", "北碚区", "万盛区", "双桥区", "渝北区", "巴南区", "万州区", "涪陵区", "黔江区", "长寿区", "江津区", "合川区", "永川区", "南川区"];
        var jiangsu = ["南京", "无锡", "常州", "徐州", "苏州", "南通", "连云港", "淮安", "扬州", "盐城", "镇江", "泰州", "宿迁"];
        var zhejiang = ["杭州", "宁波", "温州", "嘉兴", "湖州", "绍兴", "金华", "衢州", "舟山", "台州", "利水"];
        var guangdong = ["广州", "韶关", "深圳", "珠海", "汕头", "佛山", "江门", "湛江", "茂名", "肇庆", "惠州", "梅州", "汕尾", "河源", "阳江", "清远", "东莞", "中山", "潮州", "揭阳"];
        var fujiang = ["福州", "厦门", "莆田", "三明", "泉州", "漳州", "南平", "龙岩", "宁德"];
        var hunan = ["长沙", "株洲", "湘潭", "衡阳", "邵阳", "岳阳", "常德", "张家界", "益阳", "郴州", "永州", "怀化", "娄底", "湘西土家苗族自治区"];
        var hubei = ["武汉", "襄阳", "黄石", "十堰", "宜昌", "鄂州", "荆门", "孝感", "荆州", "黄冈", "咸宁", "随州", "恩施土家族苗族自治州"];
        var liaoning = ["沈阳", "大连", "鞍山", "抚顺", "本溪", "丹东", "锦州", "营口", "阜新", "辽阳", "盘锦", "铁岭", "朝阳", "葫芦岛"];
        var jilin = ["长春", "吉林", "四平", "辽源", "通化", "白山", "松原", "白城", "延边朝鲜族自治区"];
        var heilongjiang = ["哈尔滨", "齐齐哈尔", "鸡西", "牡丹江", "佳木斯", "大庆", "伊春", "黑河", "大兴安岭"];
        var hebei = ["石家庄", "保定", "唐山", "邯郸", "承德", "廊坊", "衡水", "秦皇岛", "张家口"];
        var henan = ["郑州", "洛阳", "商丘", "安阳", "南阳", "开封", "平顶山", "焦作", "新乡", "鹤壁", "许昌", "漯河", "三门峡", "信阳", "周口", "驻马店", "济源"];
        var shandong = ["济南", "青岛", "菏泽", "淄博", "枣庄", "东营", "烟台", "潍坊", "济宁", "泰安", "威海", "日照", "滨州", "德州", "聊城", "临沂"];
        var shangxi = ["西安", "宝鸡", "咸阳", "渭南", "铜川", "延安", "榆林", "汉中", "安康", "商洛"];
        var gansu = ["兰州", "嘉峪关", "金昌", "金川", "白银", "天水", "武威", "张掖", "酒泉", "平凉", "庆阳", "定西", "陇南", "临夏", "合作"];
        var qinghai = ["西宁", "海东地区", "海北藏族自治州", "黄南藏族自治州", "海南藏族自治州", "果洛藏族自治州", "玉树藏族自治州", "海西蒙古族藏族自治州"];
        var xinjiang = ["乌鲁木齐", "奎屯", "石河子", "昌吉", "吐鲁番", "库尔勒", "阿克苏", "喀什", "伊宁", "克拉玛依", "塔城", "哈密", "和田", "阿勒泰", "阿图什", "博乐"];
        var shanxi = ["太原", "大同", "阳泉", "长治", "晋城", "朔州", "晋中", "运城", "忻州", "临汾", "吕梁"];
        var sichuan = ["成都", "自贡", "攀枝花", "泸州", "德阳", "绵阳", "广元", "遂宁", "内江", "乐山", "南充", "眉山", "宜宾", "广安", "达州", "雅安", "巴中", "资阳", "阿坝藏族羌族自治州", "甘孜藏族自治州", "凉山彝族自治州"];
        var guizhou = ["贵阳", "六盘水", "遵义", "安顺", "黔南布依族苗族自治州", "黔西南布依族苗族自治州", "黔东南苗族侗族自治州", "铜仁", "毕节"];
        var anhui = ["合肥", "芜湖", "安庆", "马鞍山", "阜阳", "六安", "滁州", "宿州", "蚌埠", "巢湖", "淮南", "宣城", "亳州", "淮北", "铜陵", "黄山", "池州"];
        var jiangxi = ["南昌", "九江", "景德镇", "萍乡", "新余", "鹰潭", "赣州", "宜春", "上饶", "吉安", "抚州"];
        var yunnan = ["昆明", "曲靖", "玉溪", "保山", "昭通", "丽江", "普洱", "临沧", "楚雄彝族自治州", "大理白族自治州", "红河哈尼族彝族自治州", "文山壮族苗族自治州", "西双版纳傣族自治州", "德宏傣族景颇族自治州", "怒江傈僳族自治州", "迪庆藏族自治州"];
        var neimenggu = ["呼和浩特", "包头", "乌海", "赤峰", "通辽", "鄂尔多斯", "呼伦贝尔", "巴彦淖尔", "乌兰察布"];
        var guangxi = ["南宁", "柳州", "桂林", "梧州", "北海", "防城港", "钦州", "贵港", "玉林", "百色", "贺州", "河池", "崇左"];
        var xizang = ["拉萨", "昌都地区", "林芝地区", "山南地区", "日喀则地区", "那曲地区", "阿里地区"];
        var ningxia = ["银川", "石嘴山", "吴忠", "固原", "中卫"];
        var hainan = ["海口", "三亚"];
        var xianggang = ["中西区", "湾仔区", "东区", "南区", "九龙城区", "油尖旺区", "观塘区", "黄大仙区", "深水埗区", "北区", "大埔区", "沙田区", "西贡区", "元朗区", "屯门区", "荃湾区", "葵青区", "离岛区"];
        var taiwan = ["台北", "高雄", "基隆", "台中", "台南", "新竹", "嘉义"];
        var aomeng = ["澳门半岛", "氹仔岛", "路环岛"];

        var college = ["大学", "师范大学", "科技大学"];

        var $province = $("#province");
        var $city = $("#city");
        var $college = $("#college");

        $(function () {
            setProvince();
            $province.change(function () {
                setCity($province.val());
                setCollege($province.val(), $city.val());
            });
            $city.change(function () {
                setCollege($province.val(), $city.val());
            });
        });

        var $leftTime = $("#leftTime");
        var num = Number($leftTime.text());
        appendLeftTime();
        function appendLeftTime() {
            $leftTime.empty();
            $leftTime.append(num);
            if (num === 0) {
                //alert(1);
                //window.location.href = "http://www.baidu.com";
            } else {
                setTimeout(function () {
                    num--;
                    appendLeftTime();
                }, 1000);
            }
        }
        
        function setProvince() {
            for (var i = 0; i < province.length; i++) {
                $province.append("<option value='" + province[i] + "'>" + province[i] + "</option>")
            }
        }

        function setCollege(province, city) {
            $college.empty();
            if (city === '--请选择--'){
                $college.append("<option>--请选择--</option>");
                return;
            }
            for (var i = 0; i < college.length; i++) {
                $college.append("<option value='" + province + city + college[i] + "'>"
                    + province + city + college[i] + "</option>")
            }
        }

        function setCity(provice) {
            var proCity;
            switch (provice){
                case "北京":
                    proCity = beijing;
                    break;
                case "上海":
                    proCity = shanghai;
                    break;
                case "天津":
                    proCity = tianjing;
                    break;
                case "重庆":
                    proCity = chongqing;
                    break;
                case "浙江":
                    proCity = zhejiang;
                    break;
                case "江苏":
                    proCity = jiangsu;
                    break;
                case "广东":
                    proCity = guangdong;
                    break;
                case "福建":
                    proCity = fujiang;
                    break;
                case "湖南":
                    proCity = hunan;
                    break;
                case "湖北":
                    proCity = hubei;
                    break;
                case "辽宁":
                    proCity = liaoning;
                    break;
                case "吉林":
                    proCity = jilin;
                    break;
                case "黑龙江":
                    proCity = heilongjiang;
                    break;
                case "河北":
                    proCity = hebei;
                    break;
                case "河南":
                    proCity = henan;
                    break;
                case "山东":
                    proCity = shandong;
                    break;
                case "陕西":
                    proCity = shangxi;
                    break;
                case "甘肃":
                    proCity = gansu;
                    break;
                case "新疆":
                    proCity = xinjiang;
                    break;
                case "青海":
                    proCity = qinghai;
                    break;
                case "山西":
                    proCity = shanxi;
                    break;
                case "四川":
                    proCity = sichuan;
                    break;
                case "贵州":
                    proCity = guizhou;
                    break;
                case "安徽":
                    proCity = anhui;
                    break;
                case "江西":
                    proCity = jiangxi;
                    break;
                case "云南":
                    proCity = yunnan;
                    break;
                case "内蒙古":
                    proCity = neimenggu;
                    break;
                case "西藏":
                    proCity = xizang;
                    break;
                case "广西":
                    proCity = guangxi;
                    break;
                case "":
                    proCity = xizang;
                    break;
                case "宁夏":
                    proCity = ningxia;
                    break;
                case "海南":
                    proCity = hainan;
                    break;
                case "香港":
                    proCity = xianggang;
                    break;
                case "澳门":
                    proCity = aomeng;
                    break;
                case "台湾":
                    proCity = taiwan;
                    break;
                default :
                    proCity = defaultCity;
            }
            $city.empty();
            for (var i = 0; i < proCity.length; i++) {
                $city.append("<option value='" + proCity[i] + "'>" + proCity[i] + "</option>")
            }

        }
    </script>

</body>
</html>