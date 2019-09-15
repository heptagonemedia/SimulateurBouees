defmodule SimulateurBouees.Repo.Migrations.CreateDonnee do
  use Ecto.Migration

  def change do
    create table(:donnee) do
      add :id_bouee, :int
      add :temperature, :numeric
      add :salinite, :numeric
      add :debit, :numeric
      add :date, :timestamp
      add :batterie, :int
      add :longitude, :numeric
      add :latitude, :numeric
    end
  end
end
