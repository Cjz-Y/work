<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
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

    <input type="hidden" id="course_id" name="course_id" value="${(courseId)!''}">

    <div class="tpl-content-wrapper-hover">

        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 新增学生
                </div>
            </div>
            <div class="tpl-block ">

                <div class="am-g tpl-amazeui-form">

                    <div class="am-u-sm-12 am-u-md-9">
                        <form class="am-form am-form-horizontal" action="/student/addMark" method="post">

                            <div class="am-form-group">
                                <h3>1.你觉得本课程内容是否丰富？</h3>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question1" value="1" data-am-ucheck required> 1
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question1" value="2" data-am-ucheck> 2
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question1" value="3" data-am-ucheck> 3
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question1" value="4" data-am-ucheck> 4
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question1" value="5" data-am-ucheck> 5
                                </label>
                            </div>

                            <div class="am-form-group">
                                <h3>2.你觉得本课程的老师是否认真负责？</h3>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question2" value="1" data-am-ucheck required> 1
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question2" value="2" data-am-ucheck> 2
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question2" value="3" data-am-ucheck> 3
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question2" value="4" data-am-ucheck> 4
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question2" value="5" data-am-ucheck> 5
                                </label>
                            </div>

                            <div class="am-form-group">
                                <h3>3.你觉得本课程在你的职业生涯中是否有帮助？</h3>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question3" value="1" data-am-ucheck required> 1
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question3" value="2" data-am-ucheck> 2
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question3" value="3" data-am-ucheck> 3
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question3" value="4" data-am-ucheck> 4
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question3" value="5" data-am-ucheck> 5
                                </label>
                            </div>

                            <div class="am-form-group">
                                <h3>4.你觉得本课程中老师传授的方法和目标是否明确？</h3>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question4" value="1" data-am-ucheck required> 1
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question4" value="2" data-am-ucheck> 2
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question4" value="3" data-am-ucheck> 3
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question4" value="4" data-am-ucheck> 4
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question4" value="5" data-am-ucheck> 5
                                </label>
                            </div>

                            <div class="am-form-group">
                                <h3>5.你对本节课的总体满意程度是多少？</h3>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question5" value="1" data-am-ucheck required> 1
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question5" value="2" data-am-ucheck> 2
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question5" value="3" data-am-ucheck> 3
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question5" value="4" data-am-ucheck> 4
                                </label>
                                <label class="am-radio-inline">
                                    <input type="radio" name="question5" value="5" data-am-ucheck> 5
                                </label>
                            </div>

                            <input type="hidden" id="courseId" name="courseId" value="${courseId}"/>
                            <input type="hidden" id="studentId" name="studentId" value="${student.id}"/>
                            <input type="hidden" id="banId" name="banId" value="${student.banId}"/>
                            <input type="hidden" id="studentName" name="studentName" value="${student.username}"/>

                            <div>
                                <button type="submit" class="am-btn am-btn-primary">提交</button>
                            </div>
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
</body>

</html>