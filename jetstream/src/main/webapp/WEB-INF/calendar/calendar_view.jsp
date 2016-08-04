<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<link href='/jetstream/resources/common/fullcalendar.css' rel='stylesheet' />
<link href='/jetstream/resources/common/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='/jetstream/resources/common/lib/moment.min.js'></script>
<script src='/jetstream/resources/common/lib/jquery.min.js'></script>
<script src='/jetstream/resources/common/fullcalendar.min.js'></script>
<script>

	$(document).ready(function() {
		var jsonData = '${datalist}'
		var obj = JSON.parse(jsonData)

		var jsonData2 = '${object_today}'
		var today = JSON.parse(jsonData2)
		
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			defaultDate: today,
			selectable: true,
			selectHelper: true,
			select: function(start, end) {

				
				
				var title = prompt('Event Title:');
				var eventData;
				if (title) {
					eventData = {
						title: title,
						start: start,
						end: end
					}; 
					$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
				}
				$('#calendar').fullCalendar('unselect');
			},
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			events:   obj
		});
		
	});

</script>
<style>

	body {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 80px auto;
	}

</style>
</head>
<body>

	<div id='calendar' ></div>

</body>
</html>
