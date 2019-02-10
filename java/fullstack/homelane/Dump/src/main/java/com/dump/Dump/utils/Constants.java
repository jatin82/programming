package com.dump.Dump.utils;


import java.util.stream.Stream;

// TODO: Auto-generated Javadoc
/**
 * The Interface Constants.
 */
public interface Constants {

	/** The Constant FILE_EMPTY. */
	public final static String FILE_EMPTY = "Empty file";

	/** The Constant SUCCESS. */
	public final static String SUCCESS = "Success";

	/** The Constant FAILED. */
	public final static String FAILED = "Failed";

	/** The Constant splitByCommaRegex. */
	public final static String splitByCommaRegex = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

	/**
	 * The Enum HotelMamangementAttributes.
	 */
	public enum HotelMamangementAttributes {

		/** The address. */
		ADDRESS("address"),
		/** The categories. */
		CATEGORIES("categories"),
		/** The city. */
		CITY("city"),
		/** The country. */
		COUNTRY("country"),
		/** The latitude. */
		LATITUDE("latitude"),

		/** The longitude. */
		LONGITUDE("longitude"),
		/** The name. */
		NAME("name"),
		/** The postalcode. */
		POSTALCODE("postalCode"),
		/** The province. */
		PROVINCE("province"),

		/** The reviews rating. */
		REVIEWS_RATING("reviews.rating"),
		/** The reviews text. */
		REVIEWS_TEXT("reviews.text"),
		/** The reviews title. */
		REVIEWS_TITLE("reviews.title"),

		/** The reviews username. */
		REVIEWS_USERNAME("reviews.username");

		/** The content category. */
		private String attributes;

		/**
		 * Instantiates a new hotel mamangement attributes.
		 *
		 * @param attributes the attributes
		 */
		HotelMamangementAttributes(String attributes) {
			this.attributes = attributes;
		}

		/**
		 * Gets the content category.
		 *
		 * @return the content category
		 */
		public String getContentCategory() {
			return this.attributes;
		}

		/**
		 * Gets the content category enum.
		 *
		 * @param value the value
		 * @return the content category enum
		 */
		public static HotelMamangementAttributes getAttributes(String value) {
			return Stream.of(HotelMamangementAttributes.values())
					.filter(contentCatEnum -> contentCatEnum.getContentCategory().equalsIgnoreCase(value)).findFirst()
					.orElseThrow(() -> new IllegalArgumentException(value));
		}
	}

}
