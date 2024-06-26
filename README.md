# Spring Middleware

## Pokretanje

Za pokretanje i testiranje aplikacije potrebno je:

1. **Pokrenuti bazu podataka pomoću Dockera**:
   - Izvršite sljedeću naredbu iz vršnog direktorija projekta:
     ```sh
     docker-compose up
     ```

2. **Pokrenuti server**:
   - Server će slušati na portu 8080.

## Korištenje endpointova

- **Dodavanje proizvoda**:
POST /api/products/add


- **Dohvaćanje sažetka svih proizvoda**:
GET /api/products/getAll


- **Dohvaćanje detalja o nekom proizvodu**:
GET /api/products/{id}


- **Filtriranje proizvoda po kategoriji i cijeni**:
GET /api/products/getByPriceAndCategory?category={category}&gt={gt}&lt={lt}


- **Filtriranje proizvoda po frazi sadržanoj u imenu**:
GET /api/products/getByName?name={name}


## Napomene

- Proizvodi i korisnici dohvaćaju se sa zadanih linkova.
- Napravljena je konfiguracija za sigurnost, ali trenutno nedostaje endpoint za registraciju i prijavu, pa je omogućen slobodan pristup svemu.
- Potrebno je potpuno normalizirati tablice vezane uz korisnike.
- Preporučuje se dodavanje Facade sloja, posebno ako se planira skalirati aplikacija.
