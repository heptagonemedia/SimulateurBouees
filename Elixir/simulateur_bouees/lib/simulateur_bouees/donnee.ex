defmodule SimulateurBouees.Donnee do
  use Ecto.Schema

  schema "donnee" do
    field :id_bouee, :integer
    field :temperature, :float
    field :salinite, :float
    field :debit, :float
    field :date, :utc_datetime
    field :batterie, :integer
    field :longitude, :float
    field :latitude, :float
  end

  def changeset(donnee, params \\ %{}) do
    donnee
    |> Ecto.Changeset.cast(params, [:temperature, :salinite, :debit, :date, :batterie, :longitude, :latitude])
    |> Ecto.Changeset.validate_required([:temperature, :salinite, :debit, :date, :batterie, :longitude, :latitude])
  end
end
