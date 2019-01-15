<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="/css/amazeui.min.css" />
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="/css/app.css">
</head>

<body data-type="generalComponents">


<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <p>管理员页面</p>
    </div>
    <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

    </div>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">

            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="tpl-header-list-user-nick">禁言小张</span><span class="tpl-header-list-user-ico"> <img
                                src="/img/user01.png"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>

            <li><a href="###" class="tpl-header-list-link"><span
                            class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
        </ul>
    </div>
</header>







<div class="tpl-page-container tpl-page-header-fixed">


    <div class="tpl-content-wrapper-hover">

        <div class="tpl-content-scope">
            <div class="note note-info">
                <h3>${(ban.name)!""}
                    <span class="close" data-close="note"></span>
                </h3>
                <p> ${(ban.teacher)!""}</p>
                <#--<p><span class="label label-danger">简介:</span> ${(course.describeText)!""}-->
                </p>
            </div>
            <input type="hidden" id="ban_id" name="ban_id" value="${(ban.id)!''}">

        </div>

        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 学生名单
                </div>
            </div>

            <div class="am-g">
                <div class="am-u-sm-12 am-u-md-6">
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <button type="button" class="am-btn am-btn-default am-btn-success" onclick="window.location.href='/ban/addStudentPage?banId=${ban.id}'">
                                <span class="am-icon-plus"></span> 新增
                            </button>

                            <input id="upload" style="display: none;" accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" type="file"  class="btn btn-w-m btn-success" <#--href="/componentsExport/add"-->>
                            <button type="button" class="am-btn am-btn-default am-btn-success" id="import">
                                <span class="am-icon-plus"></span> 导入
                            </button>
                        </div>
                    </div>
                </div>
            </div>


            <div class="tpl-block ">

                <div class="am-g">
                    <div class="am-u-sm-12">
                        <form class="am-form">
                            <table id="example" class="am-table am-table-striped am-table-bordered am-table-compact">
                                <thead>
                                <tr>
                                    <th>学生名称</th>
                                </tr>
                                </thead>
                            </table>
                            <hr>

                        </form>
                    </div>

                </div>
            </div>

        </div>


    </div>

</div>


<script src="/js/jquery.min.js"></script>
<script src="/js/amazeui.min.js"></script>
<script src="/js/app.js"></script>

<script src="/js/amazeui.datatables.min.js"></script>

<script>
    $(document).ready(function() {
        $('#example').DataTable({
            "ajax": {
                "url": "/ban/showStudent",
                "type": "POST",
                data:{
                    "banId": $("#ban_id").val(),
                }
            },
            "columnDefs": [
                {
                    "data": "username",
                    "targets": 0,
                },
            ]
        } );
    } );

    $(function () {
        $('#import').on('click', function () {
            $('#upload').trigger('click');
        });
        $('#upload').on('change', function () {
            var formData = new FormData();
            formData.append('file', $('#upload')[0].files[0]);
            $.ajax({
                url: '/ban/uploadExcelData',
                type: 'POST',
                data: formData,                    // 上传formdata封装的数据
                cache: false,                      // 不缓存
                processData: false,                // jQuery不要去处理发送的数据
                contentType: false,                // jQuery不要去设置Content-Type请求头
            }).done(function(data) {
                if (data == 'success') {
                    alert("上传成功，正在处理数据，请稍后刷新页面");
                }else {
                    alert("上传失败，请稍后重试");
                }
                console.log(data);
            });
        });
    });
</script>

</body>

</html>