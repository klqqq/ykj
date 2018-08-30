/**
 * 视频管理初始化
 */
var Video = {
    id: "VideoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Video.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '视频名称', field: 'videoName', visible: true, align: 'center', valign: 'middle'},
            {title: '视频类型', field: 'videoType', visible: true, align: 'center', valign: 'middle'},
            {title: '描述', field: 'videoDesc', visible: true, align: 'center', valign: 'middle'},
            {title: '播放地址', field: 'videoUrl', visible: true, align: 'center', valign: 'middle'},
            {title: '会员ID', field: 'mId', visible: true, align: 'center', valign: 'middle'},
            {title: '点赞数', field: 'favorite', visible: true, align: 'center', valign: 'middle'},
            {title: '分享数', field: 'share', visible: true, align: 'center', valign: 'middle'},
            {title: '评论数', field: 'comment', visible: true, align: 'center', valign: 'middle'},
            {title: '状态：0审核；1正常；2下架', field: 'status', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Video.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Video.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加视频
 */
Video.openAddVideo = function () {
    var index = layer.open({
        type: 2,
        title: '添加视频',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/video/video_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看视频详情
 */
Video.openVideoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '视频详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/video/video_update/' + Video.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除视频
 */
Video.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/video/delete", function (data) {
            Feng.success("删除成功!");
            Video.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("videoId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询视频列表
 */
Video.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Video.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Video.initColumn();
    var table = new BSTable(Video.id, "/video/list", defaultColunms);
    table.setPaginationType("client");
    Video.table = table.init();
});
