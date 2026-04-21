let songs = [];

async function init(){
  let link ="https://animated-goggles-9759vvwprw9xh7rqg-8500.app.github.dev/";
  let route="tracks";
  let info = await fetch(link + route);
  songs = await info.json();
  renderSongs(songs);
  console.log(songs);
}

function renderSongs(arr) {
  let output = document.getElementById("output");

  for (let i = 0; i < arr.length; i++) {
    let track = arr[i];

    let card = `
      <div class="card">
        <h3 class="card-title">Song Name</h3>
        <p class="value">${track.Name}</p>

        <h3 class="label">Album</h3>
        <p class="value">${track.Album || "Unknown Album"}</p>

        <h3 class="label">Composer</h3>
        <p class="value">${track.Composer || "Unknown Composer"}</p>
      </div>
    `;

    output.innerHTML += card;
  }
}