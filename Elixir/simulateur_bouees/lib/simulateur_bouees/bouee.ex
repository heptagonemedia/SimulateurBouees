defmodule SimulateurBouees.Bouee do
  use Ecto.Schema

  schema "bouee" do
    field :description, :string
    field :date_debut, :utc_datetime
    field :latitude, :float
    field :longitude, :float
  end

  def changeset(bouee, params \\ %{}) do
    bouee
    |> Ecto.Changeset.cast(params, [:description, :date_debut, :latitude, :longitude])
    |> Ecto.Changeset.validate_required([ :date_debut, :latitude, :longitude])
  end

  def creerBouee(description, longitude, latitude, date_debut \\ DateTime.now("Etc/UTC")) do
    %SimulateurBouees.Bouee{description: description, longitude: longitude, latitude: latitude, date_debut: date_debut}
  end
end
