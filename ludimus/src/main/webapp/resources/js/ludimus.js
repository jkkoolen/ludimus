$(function() {
    $("#ticketDate").datepicker({ dateFormat: 'dd-mm-yy' });
    $('#fromDate').datepicker({dateFormat: 'dd-mm-yy' }).on('changeDate', function (ev) {
        $('#fromDate').datepicker('hide');
    });
    $('#toDate').datepicker({dateFormat: 'dd-mm-yy' }).on('changeDate', function (ev) {
        $('#toDate').datepicker('hide');
    });
    $('#dropdown-menu').change(function () {
        setPeriod($(this));
    });
    $('#incomeType').change(function() {
       if("true" == $(this).val()) {
           $('#forMonth').show();
       } else {
           $('#forMonth').hide();
       }
    });
    $("#endPeriod").datepicker({ dateFormat: 'dd-mm-yy' });
    setTimeout(function(){
        var $overallmessage = $('#overallmessage');
        if ($overallmessage.length > 0) {
            $overallmessage.remove();
        }
    }, 5000)
});

function setPeriod(a) {
    var now = new Date();
    var from = new Date(now.getFullYear(), 0, 1, 0, 0, 0, 0);
    var to = new Date(from.getTime());
    if(a.val() == -1)
        return;
    switch(a.val()) {
        case '0':
            from.setMonth(0);
            to.setMonth(3);
            break;
        case '1':
            from.setMonth(3);
            to.setMonth(6);
            break;
        case '2':
            from.setMonth(6);
            to.setMonth(9);
            break;
        case '3':
            from.setMonth(9);
            to.setMonth(12);
            break;
        case '4':
            from.setMonth(0);
            to = now;
            break;
    }
    $('#fromDate').datepicker("setDate", from);
    $('#toDate').datepicker("setDate", to);
}
