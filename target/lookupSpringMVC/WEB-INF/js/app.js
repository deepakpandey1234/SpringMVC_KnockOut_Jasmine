//[{"id":"11","name":"Apollo Spectra Hospitals","category":"Hospital","rating":"3","latitude":"12.9271311","longitude":"77.6063377"},
function DataModel(id, name, category, rating, latitude, longitude) {
	var self = this;

	self.selected = ko.observable(false);
	self.id = id;
	self.name = name;
	self.category = category;
	self.rating = rating;
	self.latitude = latitude;
	self.longitude = longitude;
};

var ViewModelData = function() {
	var self = this ;

	self.allData = [] ;
	
	var loadData=function(){
		$.ajax({
			url : "list",
			type : "GET",
			dataType : "json",
			success : function(data) {
				for (var i = 0; i < data.length; i++) {	
					var datamodel = new DataModel(data[i].id,data[i].name,data[i].category,data[i].rating,data[i].longitude);
					self.allData.push(datamodel);
				}
			},
			error:function(){
				alert("Error");
			}
		});		
	};
};

$(document).ready(function() {
	var viewModel = new ViewModelData();
	ko.applyBindings(viewModel);
	viewModel.load();
});