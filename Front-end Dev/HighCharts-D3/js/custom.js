var i =0;
		var mcsv = new Array();
		//var myChart;
		    function plotHighCharts(csv) {

		          $('#container').highcharts({

		            title: {
		                text: 'Water Monitoring'
		            },

		            subtitle: {
		                text: 'Live stream of water levels of reservoir'
		            },

		            xAxis: {
		                tickInterval: 3600 * 1000, // one week
		                tickWidth: 0,
		                gridLineWidth: 1,
		                labels: {
		                    align: 'left',
		                    x: 3,
		                    y: -3
		                }
		            },

		            yAxis: [{ // left y axis
		                title: {
		                    text: null
		                },
		                labels: {
		                    align: 'left',
		                    x: 3,
		                    y: 16,
		                    format: '{value:.,0f}'
		                },
		                showFirstLabel: false
		            }, { // right y axis
		                linkedTo: 0,
		                gridLineWidth: 0,
		                opposite: true,
		                title: {
		                    text: null
		                },
		                labels: {
		                    align: 'right',
		                    x: -3,
		                    y: 16,
		                    format: '{value:.,0f}'
		                },
		                showFirstLabel: false
		            }],

		            legend: {
		                align: 'left',
		                verticalAlign: 'top',
		                y: 20,
		                floating: true,
		                borderWidth: 0
		            },

		            tooltip: {
		                shared: true,
		                crosshairs: true
		            },

		            plotOptions: {
		                series: {
		                    cursor: 'pointer',
		                    point: {
		                        events: {
		                            click: function (e) {
		                                hs.htmlExpand(null, {
		                                    pageOrigin: {
		                                        x: e.pageX,
		                                        y: e.pageY
		                                    },
		                                    headingText: this.series.name,
		                                    maincontentText: Highcharts.dateFormat('%A, %b %e, %Y', this.x) + ':<br/> ' +
		                                        this.y  + ' thousand gallons',
		                                    width: 200
		                                });
		                            }
		                        }
		                    },
		                    marker: {
		                        lineWidth: 1
		                    }
		                }
		            },

		            series: [		       
		            	{
		            		id: 'series-1',
			                name: 'Water Level',
			                lineWidth: 4,
			                marker: {
			                    radius: 4
			                },
			                data: mcsv
		            	}
		            ]
		        });
		    };

		    $(function () {
		    	plotHighCharts(mcsv);

		    	plotLiquidGuage();
		    });

			setInterval(function() {
			 $.ajax({
			    url: 'http://www.highcharts.com/samples/data/jsonp.php?filename=analytics.csv&callback=?',
			    type: 'GET',
			    async: true,
			    dataType: "json",
			    success: function (data) {
			    	//var str = ","+data.split(",")[i]+",";
			    	var valX = Math.random(450,500);
			    	mcsv.push([data[i].key, valX]);
			        i+=1;
			        plotHighCharts(mcsv);
			    }
			  });
			 }, 3000);


			function plotLiquidGuage() {
				var config1 = liquidFillGaugeDefaultSettings();
			    config1.circleColor = "#FF7777";
			    config1.textColor = "#FF4444";
			    config1.waveTextColor = "#FFAAAA";
			    config1.waveColor = "#FFDDDD";
			    config1.circleThickness = 0.2;
			    config1.textVertPosition = 0.2;
			    config1.waveAnimateTime = 1000;
			    var gauge2= loadLiquidFillGauge("fillgauge2", 65, config1);					
			}
			