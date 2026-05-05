let employees;

function init(){
  $.ajaxSetup({async: false});

  let link = "https://raw.githubusercontent.com/PorchettaEP/JSONFILES/refs/heads/main/employees";
  employees = $.getJSON(link).responseJSON;

  generateCards(employees);
}

function generateCards(employees){
  let mainpanel = document.getElementById("centerpanel");
  mainpanel.innerHTML = "";

  let count = document.getElementById("count");
  if(count){
    count.innerHTML = `Number found: ${employees.length}`;
  }

  for(let i = 0; i < employees.length; i++){
    let employee = employees[i];

    let text = `
      <div class="card">
        <h3>Employee ID: ${employee.EmployeeId}</h3>
        <p>First Name: ${employee.FirstName}</p>
        <p>Last Name: ${employee.LastName}</p>
      </div>
    `;

    let content = `
      <div class="card">
        <h3>${employee.City}</h3>
        <img src="cities/${employee.City}.PNG" alt="${employee.City} flag">
      </div>
    `;

    let modal = new Modal(text, content);
    modal.render("centerpanel");
  }
}

function filter(){
  let city = document.getElementById("city").value.toLowerCase();

  let newEmployees = [];

  for(let i = 0; i < employees.length; i++){
    let employee = employees[i];

    if(employee.City.toLowerCase() == city){
      newEmployees.push(employee);
    }
  }

  generateCards(newEmployees);
}
