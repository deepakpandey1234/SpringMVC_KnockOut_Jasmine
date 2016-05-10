describe("model check", function() {
  it("computes id based on input", function() {
    var target = new DataModel("1","Deepak","test",3,21212.44,4243243.3324);
    expect(target.id).toBe(1);
  });
});