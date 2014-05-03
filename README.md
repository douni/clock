clock
=====

set time vivid
一个时钟组件，它继承自viewgroup，可以像一般的组件（textview等）一样使用。
使用方法：
第一步，在xml里面或者代码里创建一个clockwidget类型的对象
第二步，一定要执行该对象的init()方法进行初始化，init的参数是ClockParams类型的对象，该对象可以通过如下方式获得：
ClockWidget.ParamsBuilder paramsBuilder = new ClockWidget.ParamsBuilder();
paramsBuilder.createClockParams();
当然，builder可以set一些参数。

注意：
这个项目有些bug需要修改，而且有些bug需要一些特殊的方式去修正，比如，因为计算的时候角度数据用的double，虽然已经很精确了，但是当分钟调整，时针跟着动的时候还是会有误差（因为除不尽60）
这种bug需要有一种纠错机制，在每次分针转到特定情况的时候调整时钟使其保持同步。（我的想法）
