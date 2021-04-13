
$(document).ready(function() {
	Chart.defaults.global.defaultFontSize = 18;

	//	var sizeChart = document.getElementById("departSizeChart").getContext('2d');
	//	var salaryChart = document.getElementById("departSalaryChart").getContext('2d');

	var sizeChart = $("#departSizeChart")
	var salaryChart = $("#departSalaryChart")

	$.get('http://localhost:8080/charts/department/employees', function(departments) {

		let departmentEmployees = [];
		let departmentCount = [];

		$.each(departments, function(d, size) {
			departmentEmployees.push(d);
			departmentCount.push(size);
			console.log("department:" + d + "size:" + size);
		});

		var departmentSizeChart = new Chart(sizeChart, {

			// The type of chart we want to create
			type: 'bar',

			// The data for our dataset
			data: {
				labels: departmentEmployees,
				datasets: [{
					label: 'Number of Employees in Each Department',
					backgroundColor: 'rgb(255, 99, 132)',
					borderColor: 'rgb(255, 99, 132)',
					data: departmentCount
				}]
			},

			// Configuration options go here
			options: {
				title: {
					display: true,
					text: 'Employees in Departments',
					fontSize: 25
				}
			}
		});


		$.get('http://localhost:8080/charts/department/salary', function(departments) {

			let dArr2 = [];
			let sArr2 = [];

			$.each(departments, function(d, salary) {
				dArr2.push(d);
				sArr2.push(salary);
			});

			var departmentSalaryChart = new Chart(salaryChart, {

				// The type of chart we want to create
				type: 'bar',

				// The data for our dataset
				data: {
					labels: dArr2,
					datasets: [{
						label: 'Total Salary',
						backgroundColor: 'rgb(87, 160, 217)',
						borderColor: 'rgb(87, 160, 217)',
						data: sArr2
					}]
				},

				// Configuration options go here
				options: {
					title: {
						display: true,
						text: 'Total Salary in Departments',
						fontSize: 25
					}
				}
			});

		});
	});
});
