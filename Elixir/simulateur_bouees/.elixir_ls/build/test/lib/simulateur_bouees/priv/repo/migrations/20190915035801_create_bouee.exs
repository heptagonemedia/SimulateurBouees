defmodule SimulateurBouees.Repo.Migrations.CreateBouee do
  use Ecto.Migration

  def change do
    create table(:bouee) do
      add :description, :string
      add :date_debut, :timestamp
      add :latitude, :numeric
      add :longitude, :numeric
    end
  end
end
