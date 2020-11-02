package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

// 地域
public enum SysLanEnum {
  // 地域
  SysLanEnum_1("1", "全国", "0"),
  SysLanEnum_110000("110000", "北京市", "1"),
  SysLanEnum_110100("110100", "市辖区", "110000"),
  SysLanEnum_110101("110101", "东城区", "110100"),
  SysLanEnum_110102("110102", "西城区", "110100"),
  SysLanEnum_110105("110105", "朝阳区", "110100"),
  SysLanEnum_110106("110106", "丰台区", "110100"),
  SysLanEnum_110107("110107", "石景山区", "110100"),
  SysLanEnum_110108("110108", "海淀区", "110100"),
  SysLanEnum_110109("110109", "门头沟区", "110100"),
  SysLanEnum_110111("110111", "房山区", "110100"),
  SysLanEnum_110112("110112", "通州区", "110100"),
  SysLanEnum_110113("110113", "顺义区", "110100"),
  SysLanEnum_110114("110114", "昌平区", "110100"),
  SysLanEnum_110115("110115", "大兴区", "110100"),
  SysLanEnum_110116("110116", "怀柔区", "110100"),
  SysLanEnum_110117("110117", "平谷区", "110100"),
  SysLanEnum_120000("120000", "天津市", "1"),
  SysLanEnum_120100("120100", "市辖区", "120000"),
  SysLanEnum_120101("120101", "和平区", "120100"),
  SysLanEnum_120102("120102", "河东区", "120100"),
  SysLanEnum_120103("120103", "河西区", "120100"),
  SysLanEnum_120104("120104", "南开区", "120100"),
  SysLanEnum_120105("120105", "河北区", "120100"),
  SysLanEnum_120106("120106", "红桥区", "120100"),
  SysLanEnum_120110("120110", "东丽区", "120100"),
  SysLanEnum_120111("120111", "西青区", "120100"),
  SysLanEnum_120112("120112", "津南区", "120100"),
  SysLanEnum_120113("120113", "北辰区", "120100"),
  SysLanEnum_120114("120114", "武清区", "120100"),
  SysLanEnum_120115("120115", "宝坻区", "120100"),
  SysLanEnum_120116("120116", "滨海新区", "120100"),
  SysLanEnum_130000("130000", "河北省", "1"),
  SysLanEnum_130100("130100", "石家庄市", "130000"),
  SysLanEnum_130200("130200", "唐山市", "130000"),
  SysLanEnum_130300("130300", "秦皇岛市", "130000"),
  SysLanEnum_130400("130400", "邯郸市", "130000"),
  SysLanEnum_130500("130500", "邢台市", "130000"),
  SysLanEnum_130600("130600", "保定市", "130000"),
  SysLanEnum_130700("130700", "张家口市", "130000"),
  SysLanEnum_130800("130800", "承德市", "130000"),
  SysLanEnum_130900("130900", "沧州市", "130000"),
  SysLanEnum_131000("131000", "廊坊市", "130000"),
  SysLanEnum_131100("131100", "衡水市", "130000"),
  SysLanEnum_140000("140000", "山西省", "1"),
  SysLanEnum_140100("140100", "太原市", "140000"),
  SysLanEnum_140200("140200", "大同市", "140000"),
  SysLanEnum_140300("140300", "阳泉市", "140000"),
  SysLanEnum_140400("140400", "长治市", "140000"),
  SysLanEnum_140500("140500", "晋城市", "140000"),
  SysLanEnum_140600("140600", "朔州市", "140000"),
  SysLanEnum_140700("140700", "晋中市", "140000"),
  SysLanEnum_140800("140800", "运城市", "140000"),
  SysLanEnum_140900("140900", "忻州市", "140000"),
  SysLanEnum_141000("141000", "临汾市", "140000"),
  SysLanEnum_141100("141100", "吕梁市", "140000"),
  SysLanEnum_150000("150000", "内蒙古自治区", "1"),
  SysLanEnum_150100("150100", "呼和浩特市", "150000"),
  SysLanEnum_150200("150200", "包头市", "150000"),
  SysLanEnum_150300("150300", "乌海市", "150000"),
  SysLanEnum_150400("150400", "赤峰市", "150000"),
  SysLanEnum_150500("150500", "通辽市", "150000"),
  SysLanEnum_150600("150600", "鄂尔多斯市", "150000"),
  SysLanEnum_150700("150700", "呼伦贝尔市", "150000"),
  SysLanEnum_150800("150800", "巴彦淖尔市", "150000"),
  SysLanEnum_150900("150900", "乌兰察布市", "150000"),
  SysLanEnum_152200("152200", "兴安盟", "150000"),
  SysLanEnum_152500("152500", "锡林郭勒盟", "150000"),
  SysLanEnum_152900("152900", "阿拉善盟", "150000"),
  SysLanEnum_210000("210000", "辽宁省", "1"),
  SysLanEnum_210100("210100", "沈阳市", "210000"),
  SysLanEnum_210200("210200", "大连市", "210000"),
  SysLanEnum_210300("210300", "鞍山市", "210000"),
  SysLanEnum_210400("210400", "抚顺市", "210000"),
  SysLanEnum_210500("210500", "本溪市", "210000"),
  SysLanEnum_210600("210600", "丹东市", "210000"),
  SysLanEnum_210700("210700", "锦州市", "210000"),
  SysLanEnum_210800("210800", "营口市", "210000"),
  SysLanEnum_210900("210900", "阜新市", "210000"),
  SysLanEnum_211000("211000", "辽阳市", "210000"),
  SysLanEnum_211100("211100", "盘锦市", "210000"),
  SysLanEnum_211200("211200", "铁岭市", "210000"),
  SysLanEnum_211300("211300", "朝阳市", "210000"),
  SysLanEnum_211400("211400", "葫芦岛市", "210000"),
  SysLanEnum_220000("220000", "吉林省", "1"),
  SysLanEnum_220100("220100", "长春市", "220000"),
  SysLanEnum_220200("220200", "吉林市", "220000"),
  SysLanEnum_220300("220300", "四平市", "220000"),
  SysLanEnum_220400("220400", "辽源市", "220000"),
  SysLanEnum_220500("220500", "通化市", "220000"),
  SysLanEnum_220600("220600", "白山市", "220000"),
  SysLanEnum_220700("220700", "松原市", "220000"),
  SysLanEnum_220800("220800", "白城市", "220000"),
  SysLanEnum_222400("222400", "延边朝鲜族自治州", "220000"),
  SysLanEnum_230000("230000", "黑龙江省", "1"),
  SysLanEnum_230100("230100", "哈尔滨市", "230000"),
  SysLanEnum_230200("230200", "齐齐哈尔市", "230000"),
  SysLanEnum_230300("230300", "鸡西市", "230000"),
  SysLanEnum_230400("230400", "鹤岗市", "230000"),
  SysLanEnum_230500("230500", "双鸭山市", "230000"),
  SysLanEnum_230600("230600", "大庆市", "230000"),
  SysLanEnum_230700("230700", "伊春市", "230000"),
  SysLanEnum_230800("230800", "佳木斯市", "230000"),
  SysLanEnum_230900("230900", "七台河市", "230000"),
  SysLanEnum_231000("231000", "牡丹江市", "230000"),
  SysLanEnum_231100("231100", "黑河市", "230000"),
  SysLanEnum_231200("231200", "绥化市", "230000"),
  SysLanEnum_232700("232700", "大兴安岭地区", "230000"),
  SysLanEnum_310000("310000", "上海市", "1"),
  SysLanEnum_310100("310100", "市辖区", "310000"),
  SysLanEnum_310101("310101", "黄浦区", "310100"),
  SysLanEnum_310104("310104", "徐汇区", "310100"),
  SysLanEnum_310105("310105", "长宁区", "310100"),
  SysLanEnum_310106("310106", "静安区", "310100"),
  SysLanEnum_310107("310107", "普陀区", "310100"),
  SysLanEnum_310108("310108", "闸北区", "310100"),
  SysLanEnum_310109("310109", "虹口区", "310100"),
  SysLanEnum_310110("310110", "杨浦区", "310100"),
  SysLanEnum_310112("310112", "闵行区", "310100"),
  SysLanEnum_310113("310113", "宝山区", "310100"),
  SysLanEnum_310114("310114", "嘉定区", "310100"),
  SysLanEnum_310115("310115", "浦东新区", "310100"),
  SysLanEnum_310116("310116", "金山区", "310100"),
  SysLanEnum_310117("310117", "松江区", "310100"),
  SysLanEnum_310118("310118", "青浦区", "310100"),
  SysLanEnum_310120("310120", "奉贤区", "310100"),
  SysLanEnum_320000("320000", "江苏省", "1"),
  SysLanEnum_320100("320100", "南京市", "320000"),
  SysLanEnum_320200("320200", "无锡市", "320000"),
  SysLanEnum_320300("320300", "徐州市", "320000"),
  SysLanEnum_320400("320400", "常州市", "320000"),
  SysLanEnum_320500("320500", "苏州市", "320000"),
  SysLanEnum_320600("320600", "南通市", "320000"),
  SysLanEnum_320700("320700", "连云港市", "320000"),
  SysLanEnum_320800("320800", "淮安市", "320000"),
  SysLanEnum_320900("320900", "盐城市", "320000"),
  SysLanEnum_321000("321000", "扬州市", "320000"),
  SysLanEnum_321100("321100", "镇江市", "320000"),
  SysLanEnum_321200("321200", "泰州市", "320000"),
  SysLanEnum_321300("321300", "宿迁市", "320000"),
  SysLanEnum_330000("330000", "浙江省", "1"),
  SysLanEnum_330100("330100", "杭州市", "330000"),
  SysLanEnum_330200("330200", "宁波市", "330000"),
  SysLanEnum_330300("330300", "温州市", "330000"),
  SysLanEnum_330400("330400", "嘉兴市", "330000"),
  SysLanEnum_330500("330500", "湖州市", "330000"),
  SysLanEnum_330600("330600", "绍兴市", "330000"),
  SysLanEnum_330700("330700", "金华市", "330000"),
  SysLanEnum_330800("330800", "衢州市", "330000"),
  SysLanEnum_330900("330900", "舟山市", "330000"),
  SysLanEnum_331000("331000", "台州市", "330000"),
  SysLanEnum_331100("331100", "丽水市", "330000"),
  SysLanEnum_340000("340000", "安徽省", "1"),
  SysLanEnum_340100("340100", "合肥市", "340000"),
  SysLanEnum_340200("340200", "芜湖市", "340000"),
  SysLanEnum_340300("340300", "蚌埠市", "340000"),
  SysLanEnum_340400("340400", "淮南市", "340000"),
  SysLanEnum_340500("340500", "马鞍山市", "340000"),
  SysLanEnum_340600("340600", "淮北市", "340000"),
  SysLanEnum_340700("340700", "铜陵市", "340000"),
  SysLanEnum_340800("340800", "安庆市", "340000"),
  SysLanEnum_341000("341000", "黄山市", "340000"),
  SysLanEnum_341100("341100", "滁州市", "340000"),
  SysLanEnum_341200("341200", "阜阳市", "340000"),
  SysLanEnum_341300("341300", "宿州市", "340000"),
  SysLanEnum_341500("341500", "六安市", "340000"),
  SysLanEnum_341600("341600", "亳州市", "340000"),
  SysLanEnum_341700("341700", "池州市", "340000"),
  SysLanEnum_341800("341800", "宣城市", "340000"),
  SysLanEnum_350000("350000", "福建省", "1"),
  SysLanEnum_350100("350100", "福州市", "350000"),
  SysLanEnum_350200("350200", "厦门市", "350000"),
  SysLanEnum_350300("350300", "莆田市", "350000"),
  SysLanEnum_350400("350400", "三明市", "350000"),
  SysLanEnum_350500("350500", "泉州市", "350000"),
  SysLanEnum_350600("350600", "漳州市", "350000"),
  SysLanEnum_350700("350700", "南平市", "350000"),
  SysLanEnum_350800("350800", "龙岩市", "350000"),
  SysLanEnum_350900("350900", "宁德市", "350000"),
  SysLanEnum_360000("360000", "江西省", "1"),
  SysLanEnum_360100("360100", "南昌市", "360000"),
  SysLanEnum_360200("360200", "景德镇市", "360000"),
  SysLanEnum_360300("360300", "萍乡市", "360000"),
  SysLanEnum_360400("360400", "九江市", "360000"),
  SysLanEnum_360500("360500", "新余市", "360000"),
  SysLanEnum_360600("360600", "鹰潭市", "360000"),
  SysLanEnum_360700("360700", "赣州市", "360000"),
  SysLanEnum_360800("360800", "吉安市", "360000"),
  SysLanEnum_360900("360900", "宜春市", "360000"),
  SysLanEnum_361000("361000", "抚州市", "360000"),
  SysLanEnum_361100("361100", "上饶市", "360000"),
  SysLanEnum_370000("370000", "山东省", "1"),
  SysLanEnum_370100("370100", "济南市", "370000"),
  SysLanEnum_370200("370200", "青岛市", "370000"),
  SysLanEnum_370300("370300", "淄博市", "370000"),
  SysLanEnum_370400("370400", "枣庄市", "370000"),
  SysLanEnum_370500("370500", "东营市", "370000"),
  SysLanEnum_370600("370600", "烟台市", "370000"),
  SysLanEnum_370700("370700", "潍坊市", "370000"),
  SysLanEnum_370800("370800", "济宁市", "370000"),
  SysLanEnum_370900("370900", "泰安市", "370000"),
  SysLanEnum_371000("371000", "威海市", "370000"),
  SysLanEnum_371100("371100", "日照市", "370000"),
  SysLanEnum_371200("371200", "莱芜市", "370000"),
  SysLanEnum_371300("371300", "临沂市", "370000"),
  SysLanEnum_371400("371400", "德州市", "370000"),
  SysLanEnum_371500("371500", "聊城市", "370000"),
  SysLanEnum_371600("371600", "滨州市", "370000"),
  SysLanEnum_371700("371700", "菏泽市", "370000"),
  SysLanEnum_410000("410000", "河南省", "1"),
  SysLanEnum_410100("410100", "郑州市", "410000"),
  SysLanEnum_410200("410200", "开封市", "410000"),
  SysLanEnum_410300("410300", "洛阳市", "410000"),
  SysLanEnum_410400("410400", "平顶山市", "410000"),
  SysLanEnum_410500("410500", "安阳市", "410000"),
  SysLanEnum_410600("410600", "鹤壁市", "410000"),
  SysLanEnum_410700("410700", "新乡市", "410000"),
  SysLanEnum_410800("410800", "焦作市", "410000"),
  SysLanEnum_410900("410900", "濮阳市", "410000"),
  SysLanEnum_411000("411000", "许昌市", "410000"),
  SysLanEnum_411100("411100", "漯河市", "410000"),
  SysLanEnum_411200("411200", "三门峡市", "410000"),
  SysLanEnum_411300("411300", "南阳市", "410000"),
  SysLanEnum_411400("411400", "商丘市", "410000"),
  SysLanEnum_411500("411500", "信阳市", "410000"),
  SysLanEnum_411600("411600", "周口市", "410000"),
  SysLanEnum_411700("411700", "驻马店市", "410000"),
  SysLanEnum_419000("419000", "省直辖县级行政区划", "410000"),
  SysLanEnum_420000("420000", "湖北省", "1"),
  SysLanEnum_420100("420100", "武汉市", "420000"),
  SysLanEnum_420200("420200", "黄石市", "420000"),
  SysLanEnum_420300("420300", "十堰市", "420000"),
  SysLanEnum_420500("420500", "宜昌市", "420000"),
  SysLanEnum_420600("420600", "襄阳市", "420000"),
  SysLanEnum_420700("420700", "鄂州市", "420000"),
  SysLanEnum_420800("420800", "荆门市", "420000"),
  SysLanEnum_420900("420900", "孝感市", "420000"),
  SysLanEnum_421000("421000", "荆州市", "420000"),
  SysLanEnum_421100("421100", "黄冈市", "420000"),
  SysLanEnum_421200("421200", "咸宁市", "420000"),
  SysLanEnum_421300("421300", "随州市", "420000"),
  SysLanEnum_422800("422800", "恩施土家族苗族自治州", "420000"),
  SysLanEnum_429000("429000", "省直辖县级行政区划", "420000"),
  SysLanEnum_430000("430000", "湖南省", "1"),
  SysLanEnum_430100("430100", "长沙市", "430000"),
  SysLanEnum_430200("430200", "株洲市", "430000"),
  SysLanEnum_430300("430300", "湘潭市", "430000"),
  SysLanEnum_430400("430400", "衡阳市", "430000"),
  SysLanEnum_430500("430500", "邵阳市", "430000"),
  SysLanEnum_430600("430600", "岳阳市", "430000"),
  SysLanEnum_430700("430700", "常德市", "430000"),
  SysLanEnum_430800("430800", "张家界市", "430000"),
  SysLanEnum_430900("430900", "益阳市", "430000"),
  SysLanEnum_431000("431000", "郴州市", "430000"),
  SysLanEnum_431100("431100", "永州市", "430000"),
  SysLanEnum_431200("431200", "怀化市", "430000"),
  SysLanEnum_431300("431300", "娄底市", "430000"),
  SysLanEnum_433100("433100", "湘西土家族苗族自治州", "430000"),
  SysLanEnum_440000("440000", "广东省", "1"),
  SysLanEnum_440100("440100", "广州市", "440000"),
  SysLanEnum_440200("440200", "韶关市", "440000"),
  SysLanEnum_440300("440300", "深圳市", "440000"),
  SysLanEnum_440400("440400", "珠海市", "440000"),
  SysLanEnum_440500("440500", "汕头市", "440000"),
  SysLanEnum_440600("440600", "佛山市", "440000"),
  SysLanEnum_440700("440700", "江门市", "440000"),
  SysLanEnum_440800("440800", "湛江市", "440000"),
  SysLanEnum_440900("440900", "茂名市", "440000"),
  SysLanEnum_441200("441200", "肇庆市", "440000"),
  SysLanEnum_441300("441300", "惠州市", "440000"),
  SysLanEnum_441400("441400", "梅州市", "440000"),
  SysLanEnum_441500("441500", "汕尾市", "440000"),
  SysLanEnum_441600("441600", "河源市", "440000"),
  SysLanEnum_441700("441700", "阳江市", "440000"),
  SysLanEnum_441800("441800", "清远市", "440000"),
  SysLanEnum_441900("441900", "东莞市", "440000"),
  SysLanEnum_442000("442000", "中山市", "440000"),
  SysLanEnum_445100("445100", "潮州市", "440000"),
  SysLanEnum_445200("445200", "揭阳市", "440000"),
  SysLanEnum_445300("445300", "云浮市", "440000"),
  SysLanEnum_450000("450000", "广西壮族自治区", "1"),
  SysLanEnum_450100("450100", "南宁市", "450000"),
  SysLanEnum_450200("450200", "柳州市", "450000"),
  SysLanEnum_450300("450300", "桂林市", "450000"),
  SysLanEnum_450400("450400", "梧州市", "450000"),
  SysLanEnum_450500("450500", "北海市", "450000"),
  SysLanEnum_450600("450600", "防城港市", "450000"),
  SysLanEnum_450700("450700", "钦州市", "450000"),
  SysLanEnum_450800("450800", "贵港市", "450000"),
  SysLanEnum_450900("450900", "玉林市", "450000"),
  SysLanEnum_451000("451000", "百色市", "450000"),
  SysLanEnum_451100("451100", "贺州市", "450000"),
  SysLanEnum_451200("451200", "河池市", "450000"),
  SysLanEnum_451300("451300", "来宾市", "450000"),
  SysLanEnum_451400("451400", "崇左市", "450000"),
  SysLanEnum_460000("460000", "海南省", "1"),
  SysLanEnum_460100("460100", "海口市", "460000"),
  SysLanEnum_460200("460200", "三亚市", "460000"),
  SysLanEnum_460300("460300", "三沙市", "460000"),
  SysLanEnum_469000("469000", "省直辖县级行政区划", "460000"),
  SysLanEnum_500000("500000", "重庆市", "1"),
  SysLanEnum_500100("500100", "市辖区", "500000"),
  SysLanEnum_500101("500101", "万州区", "500100"),
  SysLanEnum_500102("500102", "涪陵区", "500100"),
  SysLanEnum_500103("500103", "渝中区", "500100"),
  SysLanEnum_500104("500104", "大渡口区", "500100"),
  SysLanEnum_500105("500105", "江北区", "500100"),
  SysLanEnum_500106("500106", "沙坪坝区", "500100"),
  SysLanEnum_500107("500107", "九龙坡区", "500100"),
  SysLanEnum_500108("500108", "南岸区", "500100"),
  SysLanEnum_500109("500109", "北碚区", "500100"),
  SysLanEnum_500110("500110", "綦江区", "500100"),
  SysLanEnum_500111("500111", "大足区", "500100"),
  SysLanEnum_500112("500112", "渝北区", "500100"),
  SysLanEnum_500113("500113", "巴南区", "500100"),
  SysLanEnum_500114("500114", "黔江区", "500100"),
  SysLanEnum_500115("500115", "长寿区", "500100"),
  SysLanEnum_500116("500116", "江津区", "500100"),
  SysLanEnum_500117("500117", "合川区", "500100"),
  SysLanEnum_500118("500118", "永川区", "500100"),
  SysLanEnum_500119("500119", "南川区", "500100"),
  SysLanEnum_500120("500120", "璧山区", "500100"),
  SysLanEnum_500151("500151", "铜梁区", "500100"),
  SysLanEnum_510000("510000", "四川省", "1"),
  SysLanEnum_510100("510100", "成都市", "510000"),
  SysLanEnum_510300("510300", "自贡市", "510000"),
  SysLanEnum_510400("510400", "攀枝花市", "510000"),
  SysLanEnum_510500("510500", "泸州市", "510000"),
  SysLanEnum_510600("510600", "德阳市", "510000"),
  SysLanEnum_510700("510700", "绵阳市", "510000"),
  SysLanEnum_510800("510800", "广元市", "510000"),
  SysLanEnum_510900("510900", "遂宁市", "510000"),
  SysLanEnum_511000("511000", "内江市", "510000"),
  SysLanEnum_511100("511100", "乐山市", "510000"),
  SysLanEnum_511300("511300", "南充市", "510000"),
  SysLanEnum_511400("511400", "眉山市", "510000"),
  SysLanEnum_511500("511500", "宜宾市", "510000"),
  SysLanEnum_511600("511600", "广安市", "510000"),
  SysLanEnum_511700("511700", "达州市", "510000"),
  SysLanEnum_511800("511800", "雅安市", "510000"),
  SysLanEnum_511900("511900", "巴中市", "510000"),
  SysLanEnum_512000("512000", "资阳市", "510000"),
  SysLanEnum_513200("513200", "阿坝藏族羌族自治州", "510000"),
  SysLanEnum_513300("513300", "甘孜藏族自治州", "510000"),
  SysLanEnum_513400("513400", "凉山彝族自治州", "510000"),
  SysLanEnum_520000("520000", "贵州省", "1"),
  SysLanEnum_520100("520100", "贵阳市", "520000"),
  SysLanEnum_520200("520200", "六盘水市", "520000"),
  SysLanEnum_520300("520300", "遵义市", "520000"),
  SysLanEnum_520400("520400", "安顺市", "520000"),
  SysLanEnum_520500("520500", "毕节市", "520000"),
  SysLanEnum_520600("520600", "铜仁市", "520000"),
  SysLanEnum_522300("522300", "黔西南布依族苗族自治州", "520000"),
  SysLanEnum_522600("522600", "黔东南苗族侗族自治州", "520000"),
  SysLanEnum_522700("522700", "黔南布依族苗族自治州", "520000"),
  SysLanEnum_530000("530000", "云南省", "1"),
  SysLanEnum_530100("530100", "昆明市", "530000"),
  SysLanEnum_530300("530300", "曲靖市", "530000"),
  SysLanEnum_530400("530400", "玉溪市", "530000"),
  SysLanEnum_530500("530500", "保山市", "530000"),
  SysLanEnum_530600("530600", "昭通市", "530000"),
  SysLanEnum_530700("530700", "丽江市", "530000"),
  SysLanEnum_530800("530800", "普洱市", "530000"),
  SysLanEnum_530900("530900", "临沧市", "530000"),
  SysLanEnum_532300("532300", "楚雄彝族自治州", "530000"),
  SysLanEnum_532500("532500", "红河哈尼族彝族自治州", "530000"),
  SysLanEnum_532600("532600", "文山壮族苗族自治州", "530000"),
  SysLanEnum_532800("532800", "西双版纳傣族自治州", "530000"),
  SysLanEnum_532900("532900", "大理白族自治州", "530000"),
  SysLanEnum_533100("533100", "德宏傣族景颇族自治州", "530000"),
  SysLanEnum_533300("533300", "怒江傈僳族自治州", "530000"),
  SysLanEnum_533400("533400", "迪庆藏族自治州", "530000"),
  SysLanEnum_540000("540000", "西藏自治区", "1"),
  SysLanEnum_540100("540100", "拉萨市", "540000"),
  SysLanEnum_540200("540200", "日喀则市", "540000"),
  SysLanEnum_542100("542100", "昌都地区", "540000"),
  SysLanEnum_542200("542200", "山南地区", "540000"),
  SysLanEnum_542400("542400", "那曲地区", "540000"),
  SysLanEnum_542500("542500", "阿里地区", "540000"),
  SysLanEnum_542600("542600", "林芝地区", "540000"),
  SysLanEnum_610000("610000", "陕西省", "1"),
  SysLanEnum_610100("610100", "西安市", "610000"),
  SysLanEnum_610200("610200", "铜川市", "610000"),
  SysLanEnum_610300("610300", "宝鸡市", "610000"),
  SysLanEnum_610400("610400", "咸阳市", "610000"),
  SysLanEnum_610500("610500", "渭南市", "610000"),
  SysLanEnum_610600("610600", "延安市", "610000"),
  SysLanEnum_610700("610700", "汉中市", "610000"),
  SysLanEnum_610800("610800", "榆林市", "610000"),
  SysLanEnum_610900("610900", "安康市", "610000"),
  SysLanEnum_611000("611000", "商洛市", "610000"),
  SysLanEnum_620000("620000", "甘肃省", "1"),
  SysLanEnum_620100("620100", "兰州市", "620000"),
  SysLanEnum_620200("620200", "嘉峪关市", "620000"),
  SysLanEnum_620300("620300", "金昌市", "620000"),
  SysLanEnum_620400("620400", "白银市", "620000"),
  SysLanEnum_620500("620500", "天水市", "620000"),
  SysLanEnum_620600("620600", "武威市", "620000"),
  SysLanEnum_620700("620700", "张掖市", "620000"),
  SysLanEnum_620800("620800", "平凉市", "620000"),
  SysLanEnum_620900("620900", "酒泉市", "620000"),
  SysLanEnum_621000("621000", "庆阳市", "620000"),
  SysLanEnum_621100("621100", "定西市", "620000"),
  SysLanEnum_621200("621200", "陇南市", "620000"),
  SysLanEnum_622900("622900", "临夏回族自治州", "620000"),
  SysLanEnum_623000("623000", "甘南藏族自治州", "620000"),
  SysLanEnum_630000("630000", "青海省", "1"),
  SysLanEnum_630100("630100", "西宁市", "630000"),
  SysLanEnum_630200("630200", "海东市", "630000"),
  SysLanEnum_632200("632200", "海北藏族自治州", "630000"),
  SysLanEnum_632300("632300", "黄南藏族自治州", "630000"),
  SysLanEnum_632500("632500", "海南藏族自治州", "630000"),
  SysLanEnum_632600("632600", "果洛藏族自治州", "630000"),
  SysLanEnum_632700("632700", "玉树藏族自治州", "630000"),
  SysLanEnum_632800("632800", "海西蒙古族藏族自治州", "630000"),
  SysLanEnum_640000("640000", "宁夏回族自治区", "1"),
  SysLanEnum_640100("640100", "银川市", "640000"),
  SysLanEnum_640200("640200", "石嘴山市", "640000"),
  SysLanEnum_640300("640300", "吴忠市", "640000"),
  SysLanEnum_640400("640400", "固原市", "640000"),
  SysLanEnum_640500("640500", "中卫市", "640000"),
  SysLanEnum_650000("650000", "新疆维吾尔自治区", "1"),
  SysLanEnum_650100("650100", "乌鲁木齐市", "650000"),
  SysLanEnum_650200("650200", "克拉玛依市", "650000"),
  SysLanEnum_652100("652100", "吐鲁番地区", "650000"),
  SysLanEnum_652200("652200", "哈密地区", "650000"),
  SysLanEnum_652300("652300", "昌吉回族自治州", "650000"),
  SysLanEnum_652700("652700", "博尔塔拉蒙古自治州", "650000"),
  SysLanEnum_652800("652800", "巴音郭楞蒙古自治州", "650000"),
  SysLanEnum_652900("652900", "阿克苏地区", "650000"),
  SysLanEnum_653000("653000", "克孜勒苏柯尔克孜自治州", "650000"),
  SysLanEnum_653100("653100", "喀什地区", "650000"),
  SysLanEnum_653200("653200", "和田地区", "650000"),
  SysLanEnum_654000("654000", "伊犁哈萨克自治州", "650000"),
  SysLanEnum_654200("654200", "塔城地区", "650000"),
  SysLanEnum_654300("654300", "阿勒泰地区", "650000"),
  SysLanEnum_659000("659000", "自治区直辖县级行政区划", "650000"),
  SysLanEnum_710000("710000", "台湾省", "1"),
  SysLanEnum_810000("810000", "香港特别行政区", "1"),
  SysLanEnum_820000("820000", "澳门特别行政区", "1");

  private final String code;
  private final String desc;
  private final String pcode;

  SysLanEnum(String code, String desc, String pcode) {
    this.code = code;
    this.desc = desc;
    this.pcode = pcode;
  }

  public static String getSysLanEnumCode(String desc) {
    if (StringUtils.isEmpty(desc)) {
      return "";
    }
    for (SysLanEnum sysLanEnum : SysLanEnum.values()) {
      if (sysLanEnum.getDesc().equalsIgnoreCase(desc)) {
        return sysLanEnum.getCode();
      }
    }
    return desc;
  }

  public static String getSysLanEnumDesc(String code) {
    StringBuffer sb = new StringBuffer();
    if (code == null) {
      return sb.toString();
    }
    String[] s = code.split(",");
    for (int i = 0; i < s.length; i++) {
      for (SysLanEnum sysLanEnum : SysLanEnum.values()) {
        if (sysLanEnum.getCode().equalsIgnoreCase(s[i].trim())) {
          sb.append(sysLanEnum.getDesc());
        }
      }
    }
    return sb.toString();
  }

  public static String getSysLanEnumPcode(String desc) {
    if (StringUtils.isEmpty(desc)) {
      return "";
    }
    for (SysLanEnum sysLanEnum : SysLanEnum.values()) {
      if (sysLanEnum.getDesc().equalsIgnoreCase(desc)) {
        return sysLanEnum.getPcode();
      }
    }
    return desc;
  }

  public String getCode() {
    return this.code;
  }

  public String getDesc() {
    return this.desc;
  }

  public String getPcode() {
    return this.pcode;
  }
}
