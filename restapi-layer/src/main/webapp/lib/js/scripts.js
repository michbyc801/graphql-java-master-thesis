var testSalesByCategory = function () {
	var categories;
	$.get('/categories', function (data) {
		categories = data;
	});

};


var actors_list = function () {
	$.get('/actors', function (data) {
		var actorFilmMap = new Map(data.map(entry => [entry.actorId, entry.filmIds]));

		var filmIdsFlatArray = [];
		actorFilmMap.forEach(function (entry) {
			filmIdsFlatArray = filmIdsFlatArray.concat(entry);
		});
		var uniqueFilmIdsSet = new Set(filmIdsFlatArray);
		var calls = uniqueFilmIdsSet.size;
		var categoriesIdFlatArray = [];
		uniqueFilmIdsSet.forEach(function (filmId) {
			$.get('/films/' + filmId, function (filmInfo) {
				categoriesIdFlatArray = categoriesIdFlatArray.concat(filmInfo.categoryIds);
				calls--;
			});
		});

		while (calls > 0) ;

		var uniqueCategoryIds = new Set(categoriesIdFlatArray);
		calls = uniqueCategoryIds.size;

		uniqueFilmIdsSet.forEach(function (filmId) {
			$.get('/films/' + filmId, function (filmInfo) {
				categoriesIdFlatArray = categoriesIdFlatArray.concat(filmInfo.categoryIds);
				calls--;
			});
		});

		while (calls > 0) ;
		console.log("done");
	});
};


const sales_by_category = function () {
	$.get("/categories", function (categories) {
		categories.forEach(category => {
			category.films.forEach(film => {
				$.get("/inventories/film/" + film.filmId, function (inventories) {
					inventories.forEach(inventory => {
						$.get("/rentals/inventory/" + inventory.inventoryId, function (rentals) {
							rentals.forEach(rental => {
								$.get("/payments/rental/" + rental.rentalId, function (payments) {
									payments.forEach(payment => {
										//DO-NOTHING
									});
								});
							});
						});
					});
				});
			});
		});
	});
};

const sales_by_store = function () {
	$.get("/stores", function (stores) {
		stores.forEach(store => {
			$.get("/inventories/store/" + store.storeId, function (inventories) {
				inventories.forEach(inventory => {
					$.get("/rentals/inventory/" + inventory.inventoryId, function (rentals) {
						rentals.forEach(rental => {
							$.get("/payments/rental/" + rental.rentalId, function (payments) {
								payments.forEach(payment => {
									//DO-NOTHING
								});
							});
						});
					});
				});
			});
		});
	});
};