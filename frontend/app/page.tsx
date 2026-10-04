"use client";

import { useState } from "react";

type SearchResult = {
  id?: number;
  name: string;
  description?: string;
  isoCode?: string;
  country?: {
    name: string;
  };
};

export default function Home() {
  const [searchTerm, setSearchTerm] = useState("");
  const [results, setResults] = useState<SearchResult[]>([]);

  const handleSearch = async () => {
    if (!searchTerm.trim()) {
      return;
    }

    try {
      const [countriesResponse, citiesResponse] = await Promise.all([
        fetch(
          `http://localhost:8080/api/countries/search?name=${encodeURIComponent(
            searchTerm
          )}`
        ),
        fetch(
          `http://localhost:8080/api/cities/search?name=${encodeURIComponent(
            searchTerm
          )}`
        ),
      ]);

      if (!countriesResponse.ok || !citiesResponse.ok) {
        throw new Error("Search request failed");
      }

      const countries = await countriesResponse.json();
      const cities = await citiesResponse.json();

      setResults([...countries, ...cities]);
    } catch (error) {
      console.error("Search failed:", error);
    }
  };

  return (
    <main className="min-h-screen bg-[#F4FAFC] text-[#264653]">
      <nav className="flex items-center justify-between bg-[#A8DADC] px-8 py-5">
        <h1 className="text-2xl font-bold">
          🌎 YourTravelPartner
        </h1>

        <div className="flex gap-6 font-medium">
          <a href="#">Explore</a>
          <a href="#">My Trips</a>
          <a href="#">Login</a>
        </div>
      </nav>

      <section className="flex flex-col items-center px-6 py-24 text-center">
        <h2 className="text-5xl font-bold">
          Where will you go next?
        </h2>

        <p className="mt-5 text-lg">
          Discover. Plan. Travel.
        </p>

        <div className="mt-8 flex w-full max-w-xl">
          <input
            type="text"
            placeholder="Search a country or city..."
            value={searchTerm}
            onChange={(event) => setSearchTerm(event.target.value)}
            className="flex-1 rounded-l-xl border border-gray-200 bg-white px-5 py-4 outline-none"
          />

          <button
            onClick={handleSearch}
            className="rounded-r-xl bg-[#5DADE2] px-7 py-4 font-semibold text-white"
          >
            Search
          </button>
        </div>
      </section>

      {results.length > 0 && (
        <section className="mx-auto max-w-4xl px-8 pb-12">
          <h3 className="mb-6 text-2xl font-bold">
            Search Results
          </h3>

          <div className="grid gap-4 md:grid-cols-2">
            {results.map((result, index) => (
              <div
                key={`${result.name}-${index}`}
                className="rounded-2xl bg-white p-6 shadow-sm"
              >
                <h4 className="text-xl font-semibold">
                  {result.name}
                </h4>

                <p className="mt-2 text-sm text-[#5DADE2]">
                  {result.isoCode
                    ? `Country · ${result.isoCode}`
                    : `City · ${result.country?.name ?? ""}`}
                </p>

                {result.description && (
                  <p className="mt-3 text-gray-600">
                    {result.description}
                  </p>
                )}
              </div>
            ))}
          </div>
        </section>
      )}

      <section className="px-8 pb-16">
        <h3 className="mb-6 text-center text-2xl font-bold">
          Popular Destinations
        </h3>

        <div className="mx-auto grid max-w-5xl gap-6 md:grid-cols-4">
          <div className="rounded-2xl bg-white p-8 text-center shadow-sm">
            <div className="text-4xl">🇯🇵</div>
            <h4 className="mt-3 text-xl font-semibold">Tokyo</h4>
            <p className="mt-2 text-sm text-gray-500">Japan</p>
          </div>

          <div className="rounded-2xl bg-white p-8 text-center shadow-sm">
            <div className="text-4xl">🇫🇷</div>
            <h4 className="mt-3 text-xl font-semibold">Paris</h4>
            <p className="mt-2 text-sm text-gray-500">France</p>
          </div>

          <div className="rounded-2xl bg-white p-8 text-center shadow-sm">
            <div className="text-4xl">🇺🇸</div>
            <h4 className="mt-3 text-xl font-semibold">New York</h4>
            <p className="mt-2 text-sm text-gray-500">
              United States
            </p>
          </div>

          <div className="rounded-2xl bg-white p-8 text-center shadow-sm">
            <div className="text-4xl">🇨🇳</div>
            <h4 className="mt-3 text-xl font-semibold">Shanghai</h4>
            <p className="mt-2 text-sm text-gray-500">China</p>
          </div>
        </div>
      </section>
    </main>
  );
}