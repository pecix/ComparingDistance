# Distance Comparator

### 1. POST - localhost:8080/api/localizations - dodanie listy lokalizacji
##### Przykładowy JSON (przekazywany w body): 
```
[
	{
        "name": "Barcelona",
        "coordinates": {
                "latitude": 41.3828939,
                "longitude": 2.1774322	
		}
	},
    {
        "name": "Berlin",
        "coordinates": {
        	"latitude": 52.5170365,
        	"longitude": 13.3888599
        }
    },
    {
        "name": "Londyn",
        "coordinates": {
        	"latitude": 51.5073219,
        	"longitude": -0.1276474
        }
    },
    {
        "name": "Moskwa",
        "coordinates": {
        	"latitude": 55.7504461,
        	"longitude": 37.6174943
        }
    },
    {
        "name": "Nowy Jork",
        "coordinates": {
        	"latitude": 40.7127281,
        	"longitude": -74.0060152
        }
    },
    {
        "name": "Paryż",
        "coordinates": {
        	"latitude": 48.8566101,
        	"longitude": 2.3514992
        }
    },
    {
        "name": "Praga",
        "coordinates": {
        	"latitude": 50.0874654,
        	"longitude": 14.4212535
        }
    },
    {
        "name": "Rzym",
        "coordinates": {
        	"latitude": 41.894802,
        	"longitude": 12.4853384
        }
    },
    {
        "name": "Tokio",
        "coordinates": {
        	"latitude": 35.6828387,
        	"longitude": 139.7594549
        }
    },
    {
        "name": "Warszawa",
        "coordinates": {
        	"latitude": 52.2319237,
        	"longitude": 21.0067265
        }
    }
]
```

### 2. GET - localhost:8080/api/localizations - zwraca wszystkie lokalizacje
### 3. GET - localhost:8080/api/localizations/nearest - zwraca najbliższą lokalizację
##### Przykładowy JSON (przekazywany w body): 
```
{
	"latitude": 53.4301818,
	"longitude": 14.5509623
}
```

### 4. GET - localhost:8080/api/localizations/distances - zwraca nazwy i dystans w KM do wszystkich lokalizacji
##### Przykładowy JSON (przekazywany w body): 
```
{
	"latitude": 53.4301818,
	"longitude": 14.5509623
}
```


***Miały być 2 endpoint'y, ale testowo zrobiłem 2 dodatkowe, których już nie usuwałem.**
