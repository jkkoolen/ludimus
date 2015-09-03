$(function() {
	setTimeout(crawlPage, 1000);
});

function crawlPage() {
	console.log($("iframe").get(0).contentWindow.document);
}