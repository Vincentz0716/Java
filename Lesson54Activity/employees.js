let employees = [];

function init(){
  $.ajaxSetup({async:false});
  $.getJSON("https://raw.githubusercontent.com/PorchettaEP/JSONFILES/refs/heads/main/employees", function(data){
    employees = data;
  });
  displayEmployees(employees);
}

function displayEmployees(list){
  let output = "";
  for(let i = 0; i < list.length; i++){
    output += `
      <div class="card">
        <h3>Employee ID : ${list[i].EmployeeId}</h3>
        <div class="line">First Name : ${list[i].FirstName}</div>
        <div class="line">Last Name : ${list[i].LastName}</div>
        <div class="normalLine">City : ${list[i].City}</div>
        <img src="cities/${list[i].City}.PNG" alt="${list[i].City}">
        <hr>
      </div>`;
  }
  if(output === ""){
    output = "<h2>No employees found</h2>";
  }
  document.getElementById("employeeOutput").innerHTML = output;
}

function searchEmployees(){
  let userInput = document.getElementById("cityInput").value.toLowerCase();
  let filtered = [];
  for(let i = 0; i < employees.length; i++){
    if(employees[i].City.toLowerCase().includes(userInput)){
      filtered.push(employees[i]);
    }
  }
  displayEmployees(filtered);
}
