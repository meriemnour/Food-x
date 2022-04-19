<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220411094709 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE inorder CHANGE order_id order_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE inorder ADD CONSTRAINT FK_82B7DCE78D9F6D38 FOREIGN KEY (order_id) REFERENCES `order` (id)');
        $this->addSql('CREATE INDEX IDX_82B7DCE78D9F6D38 ON inorder (order_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE inorder DROP FOREIGN KEY FK_82B7DCE78D9F6D38');
        $this->addSql('DROP INDEX IDX_82B7DCE78D9F6D38 ON inorder');
        $this->addSql('ALTER TABLE inorder CHANGE order_id order_id INT NOT NULL');
    }
}
