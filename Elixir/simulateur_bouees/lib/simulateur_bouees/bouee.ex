defmodule SimulateurBouees.Bouee do
  use Ecto.Schema

  schema "bouee" do
    field :description, :string
    field :date_debut, :string
    field :latitude, :float
    field :longitude, :float
  end
end
