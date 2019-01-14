<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="/css/amazeui.min.css"/>
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="/css/app.css">
    <link rel="stylesheet" href="/css/amazeui.datatables.css"/>
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


    <div class="tpl-left-nav tpl-left-nav-hover">
        <div class="tpl-left-nav-title">
            管理列表
        </div>
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item">
                    <a href="/manager/coursePage" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-bar-chart"></i>
                        <span>课程列表</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="/manager/banPage" class="nav-link tpl-left-nav-link-list active">
                        <i class="am-icon-table"></i>
                        <span>班级列表</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>


    <div class="tpl-content-wrapper">
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 班级列表
                </div>


            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6">
                        <div class="am-btn-toolbar">
                            <div class="am-btn-group am-btn-group-xs">
                                <button type="button" class="am-btn am-btn-default am-btn-success" onclick="window.location.href='/manager/addBanPage'"><span
                                            class="am-icon-plus"></span> 新增
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <form class="am-form">
                            <table id="example" class="am-table am-table-striped am-table-bordered am-table-compact">
                                <thead>
                                <tr>
                                    <th>班级名称</th>
                                    <th>班主任</th>
                                </tr>
                                </thead>
                            </table>
                            <hr>

                        </form>
                    </div>

                </div>
            </div>
            <div class="tpl-alert"></div>
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
            // "processing": false,
            "serverSide": false,
            "ajax": {
                "url": "/manager/getAllBan",
                "type": "POST"
            },
            "columnDefs": [
                {
                    "data": "name",
                    "targets": 0,
                    "render": function (data, type, full, meta) {
                        return "<a href=''>" + data + "</a>";
                    }
                },
                {
                    "data": "teacher",
                    "targets": 1,
                },
            ]
        } );
    } );
</script>

</body>

</html>