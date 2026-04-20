let data;

function init() {
  $.get('https://animated-goggles-9759vvwprw9xh7rqg-8500.app.github.dev/tracks', function(response) {

    data = (typeof response === "string") ? JSON.parse(response) : response;

    generateCards(data);
  });
}

function generateCards(songs) {
  const output = document.getElementById('output');

  let html = "";

  songs.forEach(song => {
    html += `
      <div class="card">
        <h3>${song.Name}</h3>
        <p>Album ID: ${song.AlbumId}</p>
        <p>Duration: ${(song.Milliseconds / 60000).toFixed(2)} min</p>
        <p>Price: $${song.UnitPrice}</p>
      </div>
    `;
  });

  output.innerHTML = html;
}