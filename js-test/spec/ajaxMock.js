describe("asynchronous global error handling test suite", function() {

	var callbacks;
	var requestUrl = "localhost:9083/lookupSpringMVC/list";

	describe("should execute success callback", function() {

		beforeAll(function(done) {
			jasmine.Ajax.install();
		    callbacks = jasmine.createSpyObj('ajax callbacks', ['success', 'error']);
		    
			jasmine.Ajax.stubRequest(requestUrl).andReturn({
		        responseText: '{"response":"Success"}',
		        status: 200,
		        "contentType": 'text/plain'
		    });
		    sendAjaxRequest(requestUrl, callbacks, done);
		});
		/*beforeEach(function() {
		      jasmine.Ajax.install();
		    });*/
		
		afterAll(function() {
			jasmine.Ajax.uninstall();
		});
		/*afterEach(function() {
		      jasmine.Ajax.uninstall();
		    });
*/
		it("executes success callback", function() {
		    expect(callbacks.error).not.toHaveBeenCalled();
		    expect(callbacks.success).toHaveBeenCalled();
		});

	});
	describe("should execute error callback", function() {

		beforeAll(function(done) {
			jasmine.Ajax.install();
		    callbacks = jasmine.createSpyObj('ajax callbacks', ['success', 'error']);
		    
			jasmine.Ajax.stubRequest(requestUrl).andReturn({
		        responseText: '{"response":"Internal Server Error"}',
		        status: 500,
		        "contentType": 'text/plain'
		    });
		    sendAjaxRequest(requestUrl, callbacks, done);
		});
		
		afterAll(function() {
			jasmine.Ajax.uninstall();
		});

		it("executes error callback", function() {
		    expect(callbacks.error).toHaveBeenCalled();
		    expect(callbacks.success).not.toHaveBeenCalled();
		});

	});
	
		//Submits a Jquery ajax request with the given parameters
	
	var sendAjaxRequest = function(requestUrl, callbacks, done) {
		$.ajax({		
			url : requestUrl,
			type : "GET",
			success: callbacks.success,
			error: callbacks.error,
			complete: function() { done(); },
		});
	};
});
