let songs = [];
let genres = [];

function init(){
  $.ajaxSetup({async:false});
  $.getJSON("https://raw.githubusercontent.com/PorchettaEP/JSONFILES/refs/heads/main/songs", function(data){
    songs = data;
  });
  $.getJSON("https://raw.githubusercontent.com/PorchettaEP/JSONFILES/refs/heads/main/genres", function(data){
    genres = data;
  });
  displaySongs(songs);
}

function displaySongs(list){
  let output = "";
  for(let i = 0; i < list.length; i++){
    output += `
      <div class="card">
        <h3>Song Name</h3>
        <div class="normalLine">${list[i].songName}</div>
        <br>
        <div class="line">Album</div>
        <div>${list[i].albumName}</div>
        <div class="line">Composer</div>
        <div>${list[i].artistName}</div>
        <div class="line">Genre</div>
        <div>${list[i].genreName}</div>
        <hr>
      </div>`;
  }
  if(output === ""){
    output = "<h2>No songs found</h2>";
  }
  document.getElementById("songOutput").innerHTML = output;
}

function searchSongs(){
  let userInput = document.getElementById("songInput").value.toLowerCase();
  let filtered = [];
  for(let i = 0; i < songs.length; i++){
    if(songs[i].songName.toLowerCase().includes(userInput)){
      filtered.push(songs[i]);
    }
  }
  displaySongs(filtered);
}
