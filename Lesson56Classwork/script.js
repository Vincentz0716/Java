let customers;

function init(){
  $.ajaxSetup({async: false});

  let link = "https://raw.githubusercontent.com/PorchettaEP/JSONFILES/refs/heads/main/customers";
  customers = $.getJSON(link).responseJSON;

  generateCards(customers);
}

function generateCards(customers){
  let centerpanel = document.getElementById("centerpanel");
  centerpanel.innerHTML = "";

  let count = document.getElementById("count");
  if(count){
    count.innerHTML = `Number found: ${customers.length}`;
  }

  for(let i = 0; i < customers.length; i++){
    let customer = customers[i];

    let front = `
      <div class="card">
        <h3>Customer ID: ${customer.CustomerId}</h3>
        <p>First Name: ${customer.FirstName}</p>
        <p>Last Name: ${customer.LastName}</p>
        <p>Email: ${customer.Email}</p>
      </div>
    `;

    let back = `
      <div class="card">
        <h3>${customer.Country}</h3>
        <img src="countries/${customer.Country}.PNG" alt="${customer.Country} flag">
      </div>
    `;

    let card = new FlipCard(front, back);
    card.render("centerpanel");
  }
}

function filter(){
  let country = document.getElementById("country").value.toLowerCase();

  let customerList = [];

  for(let i = 0; i < customers.length; i++){
    let customer = customers[i];

    if(customer.Country.toLowerCase() == country){
      customerList.push(customer);
    }
  }

  generateCards(customerList);
}
