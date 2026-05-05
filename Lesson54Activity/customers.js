let customers = [];

function init(){
  $.ajaxSetup({async:false});
  $.getJSON("https://raw.githubusercontent.com/PorchettaEP/JSONFILES/refs/heads/main/customers", function(data){
    customers = data;
  });
  displayCustomers(customers);
}

function displayCustomers(list){
  let output = "";
  for(let i = 0; i < list.length; i++){
    output += `
      <div class="card">
        <h3>Customer ID : ${list[i].CustomerId}</h3>
        <div class="line">First Name : ${list[i].FirstName}</div>
        <div class="line">Last Name : ${list[i].LastName}</div>
        <div class="line">Country : ${list[i].Country}</div>
        <div class="normalLine">Email : ${list[i].Email}</div>
        <img src="countries/${list[i].Country}.PNG" alt="${list[i].Country}">
        <hr>
      </div>`;
  }
  if(output === ""){
    output = "<h2>No customers found</h2>";
  }
  document.getElementById("customerOutput").innerHTML = output;
}

function searchCustomers(){
  let userInput = document.getElementById("countryInput").value.toLowerCase();
  let filtered = [];
  for(let i = 0; i < customers.length; i++){
    if(customers[i].Country.toLowerCase().includes(userInput)){
      filtered.push(customers[i]);
    }
  }
  displayCustomers(filtered);
}
