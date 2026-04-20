
let data;

async function init(){
  let link ="https://friendly-journey-v6rvwqxgpp4pcpvqq-8500.app.github.dev/" ;
  let route="customers"
  info = await fetch(link+route);
  data = await info.json();

  //first dump the array to the console and examine 
  //the content
  console.log(data);

}