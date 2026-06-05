let skins = [];
let collections = [];
let weapons = [];
let rarities = [];
let analysis = [];

// Replace this with your public Codespaces 8500 URL if needed.
let link = "https://animated-goggles-9759vvwprw9xh7rqg-8500.app.github.dev/";

async function loadJson(route) {
  let info = await fetch(link + route);
  return await info.json();
}

function fillSelect(select, values){
  for(let i = 0; i < values.length; i++){
    let option = document.createElement("option");
    option.value = values[i];
    option.textContent = values[i];
    select.appendChild(option);
  }
}

function uniqueValues(arr){
  let out = [];
  for(let i = 0; i < arr.length; i++){
    if(out.indexOf(arr[i]) == -1){
      out[out.length] = arr[i];
    }
  }
  out.sort();
  return out;
}

function money(v){ return Math.round(Number(v)) + " VP"; }

async function initHome(){
  skins = await loadJson("skins");
  collections = await loadJson("collections");
  let stats = document.getElementById("home-stats");
  stats.innerHTML =
    '<div class="stat-card"><div>Total skins</div><div class="stat-value">' + skins.length + '</div></div>' +
    '<div class="stat-card"><div>Collections</div><div class="stat-value">' + collections.length + '</div></div>' +
    '<div class="stat-card"><div>Weapons</div><div class="stat-value">' + uniqueValues(skins.map(s => s.weapon_type)).length + '</div></div>';

  let homeSkins = document.getElementById("home-skins");
  homeSkins.innerHTML = "";
  for(let i = 0; i < Math.min(6, skins.length); i++){
    let s = skins[i];
    homeSkins.innerHTML += '<div class="row-card"><div class="row-title">' + s.skin_name + '</div><div>' + s.weapon_type + ' • ' + s.collection_name + ' • ' + money(s.price_vp) + '</div></div>';
  }

  let homeCollections = document.getElementById("home-collections");
  for(let i = 0; i < Math.min(5, collections.length); i++){
    let c = collections[i];
    homeCollections.innerHTML += '<div class="row-card"><div class="row-title">' + c.collection_name + '</div><div>' + c.theme + ' • ' + c.skin_count + ' skins</div></div>';
  }
}

async function initSkins(){
  skins = await loadJson("skins");

  fillSelect(document.getElementById("skin-weapon"), uniqueValues(skins.map(s => s.weapon_type)));
  fillSelect(document.getElementById("skin-collection"), uniqueValues(skins.map(s => s.collection_name)));
  fillSelect(document.getElementById("skin-rarity"), uniqueValues(skins.map(s => s.rarity)));

  document.getElementById("skin-search").addEventListener("input", applySkinFilters);
  document.getElementById("skin-weapon").addEventListener("change", applySkinFilters);
  document.getElementById("skin-collection").addEventListener("change", applySkinFilters);
  document.getElementById("skin-rarity").addEventListener("change", applySkinFilters);
  document.getElementById("skin-sort").addEventListener("change", applySkinFilters);

  applySkinFilters();
}

function applySkinFilters(){
  let search = document.getElementById("skin-search").value.trim().toLowerCase();
  let weapon = document.getElementById("skin-weapon").value;
  let collection = document.getElementById("skin-collection").value;
  let rarity = document.getElementById("skin-rarity").value;
  let sortValue = document.getElementById("skin-sort").value;

  let filtered = [];
  for(let i = 0; i < skins.length; i++){
    let s = skins[i];
    let okSearch = s.skin_name.toLowerCase().indexOf(search) != -1;
    let okWeapon = weapon == "all" || s.weapon_type == weapon;
    let okCollection = collection == "all" || s.collection_name == collection;
    let okRarity = rarity == "all" || s.rarity == rarity;
    if(okSearch && okWeapon && okCollection && okRarity){
      filtered[filtered.length] = s;
    }
  }

  if(sortValue == "weapon"){
    filtered.sort((a,b) => a.weapon_type.localeCompare(b.weapon_type));
  } else if(sortValue == "price-high"){
    filtered.sort((a,b) => Number(b.price_vp) - Number(a.price_vp));
  } else if(sortValue == "price-low"){
    filtered.sort((a,b) => Number(a.price_vp) - Number(b.price_vp));
  } else {
    filtered.sort((a,b) => a.skin_name.localeCompare(b.skin_name));
  }

  document.getElementById("skin-count").textContent = filtered.length + " skins";

  let grid = document.getElementById("skin-grid");
  let cards = "";
  for(let i = 0; i < filtered.length; i++){
    let s = filtered[i];
    cards += '<div class="skin-card"><div class="skin-card-inner">';
    cards += '<div class="skin-card-face"><div class="skin-badge">' + s.rarity + '</div><h3>' + s.skin_name + '</h3><div class="skin-meta"><div>Weapon: ' + s.weapon_type + '</div><div>Collection: ' + s.collection_name + '</div><div>Price: ' + money(s.price_vp) + '</div></div></div>';
    cards += '<div class="skin-card-face skin-card-back"><h3>' + s.collection_name + '</h3><p>' + s.theme + '</p><div class="skin-meta"><div>Tier: ' + s.bundle_tier + '</div><div>Release year: ' + s.release_year + '</div></div></div>';
    cards += '</div></div>';
  }
  grid.innerHTML = cards;
}

async function initAnalysis(){
  skins = await loadJson("skins");
  weapons = await loadJson("weapons");
  rarities = await loadJson("rarities");
  analysis = await loadJson("analysis");

  document.getElementById("analysis-stats").innerHTML =
    '<div class="stat-card"><div>Total skins</div><div class="stat-value">' + skins.length + '</div></div>' +
    '<div class="stat-card"><div>Average price</div><div class="stat-value">' + money(skins.reduce((sum,s)=>sum+Number(s.price_vp),0)/skins.length) + '</div></div>' +
    '<div class="stat-card"><div>Most common weapon</div><div class="stat-value">' + weapons[0].weapon_type + '</div></div>';

  renderBars("weapon-breakdown", weapons, "weapon_type");
  renderBars("rarity-breakdown", rarities, "rarity");

  let box = document.getElementById("collection-analysis");
  box.innerHTML = "";
  for(let i = 0; i < analysis.length; i++){
    let a = analysis[i];
    box.innerHTML += '<div class="row-card"><div class="row-title">' + a.collection_name + '</div><div>' + a.bundle_tier + ' • ' + a.skin_count + ' skins • ' + money(a.lowest_price) + ' to ' + money(a.highest_price) + ' • Avg: ' + money(a.average_price) + '</div></div>';
  }
}

function renderBars(id, data, titleField){
  let max = 1;
  for(let i = 0; i < data.length; i++){ max = Math.max(max, Number(data[i].skin_count)); }
  let box = document.getElementById(id);
  box.innerHTML = "";
  for(let i = 0; i < data.length; i++){
    let row = data[i];
    let width = Math.round(Number(row.skin_count) / max * 100);
    box.innerHTML += '<div class="bar-row"><div class="bar-title">' + row[titleField] + ' — ' + row.skin_count + ' skins</div><div class="bar-track"><div class="bar-fill" style="width:' + width + '%"></div></div><div class="small-note">Average price: ' + money(row.average_price) + '</div></div>';
  }
}

async function initCollections(){
  collections = await loadJson("collections");

  document.getElementById("collection-stats").innerHTML =
    '<div class="stat-card"><div>Total collections</div><div class="stat-value">' + collections.length + '</div></div>' +
    '<div class="stat-card"><div>Largest collection</div><div class="stat-value">' + collections[0].collection_name + '</div></div>' +
    '<div class="stat-card"><div>Most skins in one collection</div><div class="stat-value">' + collections[0].skin_count + '</div></div>';

  let grid = document.getElementById("collection-grid");
  grid.innerHTML = "";
  for(let i = 0; i < collections.length; i++){
    let c = collections[i];
    grid.innerHTML += '<div class="row-card"><div class="skin-badge">' + c.bundle_tier + '</div><h3>' + c.collection_name + '</h3><p>' + c.theme + '</p><div class="skin-meta"><div>Skins: ' + c.skin_count + '</div><div>Average price: ' + money(c.average_price) + '</div></div></div>';
  }
}

if(document.body.id == "home"){ initHome(); }
if(document.body.id == "skins"){ initSkins(); }
if(document.body.id == "analysis"){ initAnalysis(); }
if(document.body.id == "activity"){ initCollections(); }
