$(".projectTimer").TimeCircles({
	start : false
});
$(".timerStart").click(function() {
	$(".projectTimer").TimeCircles().start();
});
$(".timerStop").click(function() {
	$(".projectTimer").TimeCircles().stop();
});
$(".timerRestart").click(function() {
	$(".projectTimer").TimeCircles().restart();
});